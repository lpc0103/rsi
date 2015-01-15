package lpc.pageModel;

import java.util.Map;
import java.util.Set;


public class MenuTreeDTO {


//    id：节点的 id，它对于加载远程数据很重要。
//    text：要显示的节点文本。
//    state：节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
//    checked：指示节点是否被选中。
//    attributes：给一个节点添加的自定义属性。
//    children：定义了一些子节点的节点数组。

	private String id;
	private String text;
	private String state;
	private String checked;
	private String url;
	private Map<String,String> attributes;
	private Set<MenuTreeDTO> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public Set<MenuTreeDTO> getChildren() {
		return children;
	}
	public void setChildren(Set<MenuTreeDTO> children) {
		this.children = children;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
