package bean;

/**
 * @ProjectName: leetCode
 * @Package: bean
 * @ClassName: ListNode
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 14:17
 * @Version: 1.0
 */
public class ListNode {
    private String nodeValue = null;
    private ListNode pre = null;
    private ListNode suf = null;

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    public ListNode getSuf() {
        return suf;
    }

    public void setSuf(ListNode suf) {
        this.suf = suf;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "nodeValue='" + nodeValue + '\'' +
                ", pre=" + pre +
                ", suf=" + suf +
                '}';
    }
}
