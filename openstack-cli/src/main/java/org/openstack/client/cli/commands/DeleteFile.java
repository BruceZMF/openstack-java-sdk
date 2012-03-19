package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.storage.OpenstackStorageClient;
import org.openstack.client.cli.model.StoragePath;

public class DeleteFile extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public DeleteFile() {
		super("delete", "file");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackStorageClient client = getStorageClient();

		path.getResource(client).delete();

		return path.getKey();
	}

}