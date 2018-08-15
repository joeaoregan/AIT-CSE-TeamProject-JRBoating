import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class ViewBean{
	
	public String viewBoat() {
		return "boat.xtml";
		
	}
	

}
