package com.zihexin.business_interface.common.socket.connect;

import com.zihexin.business_interface.common.Utils;
import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �������
 */
public class ABCBankDataAnalyze  implements DataAnalyze {

    private final static Logger logger = LoggerFactory.getLogger(AbcConnectorSupport.class);

    /**
     * �������
     * @param buffer
     * @return
     */
    public byte[] decode(IoBuffer buffer) {
        logger.info("���뿪ʼ...");

        //��ȡһ���ֽ�  ��ʱû���õ�
        //byte lenByte = buffer.get();
        //buffer.capacity() ;
//        IoBuffer _buffer = buffer.allocate(4005).setAutoExpand(true);
//        _buffer.put(buffer.array()) ;
//        
//        buffer = _buffer ;
        
        byte[] lenBytes = new byte[8];
        buffer.get(lenBytes);
        int len = 0;
        byte[] content = null;
        try {
            String str = new String(lenBytes, Utils.CHARSET_FORNAME);
            len = Integer.valueOf(new String(str.trim().getBytes() , Utils.CHARSET_FORNAME));
            content = new byte[len];
            buffer.get(content);
            logger.info("������ɣ��յ�����Ӧ���ĵ���������,����ͷ��" + new String(lenBytes,  Utils.CHARSET_FORNAME));
            logger.info("������ɣ��յ�����Ӧ���ĵ���������,�����壺" + new String(content,  Utils.CHARSET_FORNAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * �������
     * @param message
     * @return
     */
    public IoBuffer encode(Object message) {
        IoBuffer buffer = IoBuffer.allocate(8).setAutoExpand(true);
        byte[] msg = (byte[]) message;
        try {
            logger.info("���͵����е���������:"+new String(msg,Utils.CHARSET_FORNAME));
            buffer.put(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        buffer.flip();
        //logger.info("������ɣ����͵������ݣ�"+buffer.getHexDump());
        return buffer;
    }
}

