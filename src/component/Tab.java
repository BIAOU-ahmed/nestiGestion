/**
 * 
 */
package component;

import javax.swing.JPanel;

/**
 * @author ahmed
 *
 */
public abstract class Tab extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 *  this function allows to refresh all the elements of the tab so that
	 *  in the event of change in the data base on another tab one can 
	 *  recover the data on the current tab
	 */
	public void refreshTab() {
		this.removeAll();
	}
}
