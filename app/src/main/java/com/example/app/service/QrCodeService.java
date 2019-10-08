package com.example.app.service;

import com.example.app.model.QrCode;
public interface QrCodeService{
    QrCode updateQrcode(Integer wx_id);
    QrCode selectByid(Integer id);

}
