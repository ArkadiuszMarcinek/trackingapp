package com.example.trackingapp.models;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Builder
@Entity
@NoArgsConstructor
@Setter
@DynamicUpdate
@AllArgsConstructor
@Table(name = "SHIPMENT_STATUS")
public class ShipmentStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "SHIPMENT_STATUS_ID", updatable = false)
    private @NonNull UUID shipmentStatusId;
    @Column(name = "DATE_FROM", updatable = false)
    private @NonNull LocalDateTime dateFrom;
    @Column(name = "DATE_TO")
    @With
    private LocalDateTime dateTo;
    @Column(name = "STATUS", updatable = false)
    private @NonNull ShipmentStatus.Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentStatusEntity that = (ShipmentStatusEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(shipmentStatusId, that.shipmentStatusId) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipmentStatusId, dateFrom, dateTo, status);
    }
}
