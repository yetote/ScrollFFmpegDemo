//
// Created by ether on 2019/3/2.
//


#include "Decode.h"



void Decode::prepare(const char *path) {
    int rst = 0;
    int videoIndex = -1;
    av_register_all();
    avformat_network_init();

    pFmtCtx = avformat_alloc_context();
    rst = avformat_open_input(&pFmtCtx, path, null, null);
    if (rst != 0) {
        LOGE("打开文件失败,错误码%d", rst);
        return;
    }

    rst = avformat_find_stream_info(pFmtCtx, null);
    if (rst != 0) {
        LOGE("寻找流信息失败,错误码%d", rst);
        return;
    }
    for (int i = 0; i < pFmtCtx->nb_streams; ++i) {
        if (pFmtCtx->streams[i]->codecpar->codec_type == AVMEDIA_TYPE_VIDEO) {
            videoIndex = i;
            break;
        }
    }
    if (videoIndex == -1) {
        LOGE("未找到视频流信息");
        return;
    }
    pStream = pFmtCtx->streams[videoIndex];

    pCodec = avcodec_find_decoder(pStream->codecpar->codec_id);
    if (pCodec == null) {
        LOGE("找不到解码器");
        return;
    }
    pCodecCtx = avcodec_alloc_context3(pCodec);
    rst = avcodec_parameters_to_context(pCodecCtx, pStream->codecpar);
    if (rst < 0) {
        LOGE("无法复制流信息,错误码%d", rst);
        return;
    }
    rst = avcodec_open2(pCodecCtx, pCodec, null);
    if (rst < 0) {
        LOGE("解码失败,错误码%d", rst);
        return;
    }
    callBack->onPrepare(pCodecCtx->width, pCodecCtx->height);
    AVPacket *pPacket = static_cast<AVPacket *>(av_malloc(sizeof(AVPacket)));
    pFrame = av_frame_alloc();
    while ((av_read_frame(pFmtCtx, pPacket)) >= 0) {
        if (pPacket->stream_index == videoIndex) {

            rst = avcodec_send_packet(pCodecCtx, pPacket);
            if (rst < 0) {
                LOGE("发送packet失败，错误码%d", rst);
                continue;
            }
            while (rst >= 0) {
                rst = avcodec_receive_frame(pCodecCtx, pFrame);
                LOGE("接受%d", rst);
                int num = av_image_get_buffer_size(AV_PIX_FMT_YUV420P, pFrame->width,
                                                   pFrame->height,
                                                   1);
                uint8_t *buffer = static_cast<uint8_t *>(av_malloc(num * sizeof(uint8_t)));
                av_image_fill_arrays(pFrame->data,
                                     pFrame->linesize,
                                     buffer,
                                     AV_PIX_FMT_YUV420P,
                                     pFrame->width,
                                     pFrame->height,
                                     1);
                SwsContext *swsContext = sws_getContext(pCodecCtx->width,
                                                        pCodecCtx->height,
                                                        pCodecCtx->pix_fmt,
                                                        pCodecCtx->width,
                                                        pCodecCtx->height,
                                                        AV_PIX_FMT_YUV420P,
                                                        SWS_BICUBIC,
                                                        null, null, null);
                sws_scale(swsContext, pFrame->data, pFrame->linesize, pFrame->width, pFrame->height,
                          pFrame->data, pFrame->linesize);

                av_usleep(40000);
                LOGE("解码成功");
            }
        }
    }
    LOGE("解码完成");
    av_frame_free(&pFrame);
    av_packet_free(&pPacket);
}

Decode::Decode(CallBack *callBack1) {
    this->callBack = callBack1;
}
