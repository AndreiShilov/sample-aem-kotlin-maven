package com.asd.aem.ktln.core.models;

import java.util.List;

public interface ContainerComponent extends Component {

    List<? extends Component> getItems();
}
