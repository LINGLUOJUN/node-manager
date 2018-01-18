package com.six.node_manager;


/**   
 * @author sixliu   
 * @date   2018年1月18日 
 * @email  359852326@qq.com  
 * @Description 
 */
public class NodeManagerTest2 {

	public static void main(String[] args) {
		NodeManagerBuilder builder = new NodeManagerBuilder();
		builder.setClusterEnable(true);
		builder.setClusterName("cluster");
		builder.setNodeName("node1");
		builder.setHost("127.0.0.1");
		builder.setPort(8883);
		String discoveryNodes = "127.0.0.1:8881;127.0.0.1:8882;127.0.0.1:8883";
		builder.setDiscoveryNodes(discoveryNodes);
		NodeManager nodeManager = builder.build();
		nodeManager.getNodeEventManager().registerNodeEventListen(NodeEventType.INIT_BECAOME_MASTER, node -> {
			System.out.println("listen event:" + node);
		});
		nodeManager.start();
		try {
			Thread.sleep(1111111111);
		} catch (InterruptedException e) {
		}
		nodeManager.stop();
	
	}

}
