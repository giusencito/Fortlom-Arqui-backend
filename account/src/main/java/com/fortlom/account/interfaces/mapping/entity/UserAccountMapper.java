package com.fortlom.account.interfaces.mapping.entity;




import com.fortlom.account.domain.UserAggregate.entity.Tag;
import com.fortlom.account.domain.UserAggregate.entity.UserAccount;
import com.fortlom.account.interfaces.dto.tag.CreateTagResource;
import com.fortlom.account.interfaces.dto.useraccoount.UpdatePersonResource;
import com.fortlom.account.interfaces.dto.useraccoount.UserAccountResource;
import com.fortlom.account.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.io.Serializable;
public class UserAccountMapper {

    @Autowired
    EnhancedModelMapper mapper;


    public UserAccountResource toResource(UserAccount model) {
        return mapper.map(model, UserAccountResource.class);
    }

    public Page<UserAccountResource> modelListToPage(List<UserAccount> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserAccountResource.class), pageable, modelList.size());
    }
    public UserAccount toModel(UpdatePersonResource resource) {
        return mapper.map(resource, UserAccount.class);
    }

}
