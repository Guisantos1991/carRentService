package dto;

public class CreateReservationRequest {
    private Long customerId;
    private Long branchId;
    private String reservationDate;
    private Long vehicleId;

    public CreateReservationRequest(Long customerId, Long branchId, String reservationDate) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.reservationDate = reservationDate;
    }
}
