package org.ihtsdo.elasticsnomed.core.data.domain.jobs;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Collection;
import java.util.UUID;

@Document(type = "identifiers", indexName = "es-identifiers", shards = 8)
public class IdentifiersForRegistration {

	private String id;

	@Field(type = FieldType.Integer, index = FieldIndex.not_analyzed)
	private int namespace;

	@Field(type = FieldType.Long, index = FieldIndex.not_analyzed)
	private Collection<String> ids;

	public IdentifiersForRegistration(int namespace, Collection<String> ids) {
		id = UUID.randomUUID().toString();
		this.namespace = namespace;
		this.ids = ids;
	}

	public IdentifiersForRegistration() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNamespace() {
		return namespace;
	}

	public void setNamespace(int namespace) {
		this.namespace = namespace;
	}

	public Collection<String> getIds() {
		return ids;
	}

	public void setIds(Collection<String> ids) {
		this.ids = ids;
	}
}
