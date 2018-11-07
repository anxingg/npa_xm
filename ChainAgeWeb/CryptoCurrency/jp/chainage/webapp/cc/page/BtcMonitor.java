package jp.chainage.webapp.cc.page;

import java.util.LinkedList;
import java.util.Queue;

import jp.chainage.webapp.cc.entity.CcBtcMonitorLineHistory;
import jp.chainage.webapp.cc.entity.CcBtcMonitorOhlcvHistory;

public class BtcMonitor implements java.io.Serializable {
    private static final long serialVersionUID = -4167350453182912838L;
    Queue<CcBtcMonitorLineHistory> line_his_queue;
    Queue<CcBtcMonitorOhlcvHistory> ohlcv_his_queue;

    public BtcMonitor() {
        line_his_queue = new LinkedList<CcBtcMonitorLineHistory>();
        ohlcv_his_queue = new LinkedList<CcBtcMonitorOhlcvHistory>();
    }

    public Queue<CcBtcMonitorLineHistory> getLine_his_queue() {
        return line_his_queue;
    }

    public void setLine_his_queue(Queue<CcBtcMonitorLineHistory> line_his_queue) {
        this.line_his_queue = line_his_queue;
    }

    public Queue<CcBtcMonitorOhlcvHistory> getOhlcv_his_queue() {
        return ohlcv_his_queue;
    }

    public void setOhlcv_his_queue(Queue<CcBtcMonitorOhlcvHistory> ohlcv_his_queue) {
        this.ohlcv_his_queue = ohlcv_his_queue;
    }
}
