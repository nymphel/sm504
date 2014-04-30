package tr.metu.edu.sm.cookbook.entity.parent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdName {

	@Id
	@Basic(optional = false)
	@Column(name = "id")
	protected Integer id;
	@Basic(optional = false)
	@Column(name = "name")
	protected String name;

	public IdName() {
	}

	public IdName(Integer id) {
		this.id = id;
	}

	public IdName(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
