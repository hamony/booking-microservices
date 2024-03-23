package com.ubluetech.externalapi.infrastructure.hotelbeds;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class AuditData {
    private String processTime;
    private String timestamp;
    private String requestHost;
    private String serverId;
    private String environment;
    private String release;
}
