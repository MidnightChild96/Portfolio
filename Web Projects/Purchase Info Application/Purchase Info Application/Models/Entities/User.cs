using Microsoft.EntityFrameworkCore;

namespace Purchase_Info_Application.Models.Entities
{
    [PrimaryKey(nameof(Id))]
    public class User
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string? Password { get; set; }
        public bool IsAdmin {get; set;}
        public string FirstName {  get; set; }
        public string LastName { get; set; }
        public string Phone { get; set; }   
        public string ShippingAddress {  get; set; }
        public string ShippingCity { get; set; }
        public string ShippingCountry {  get; set; }
        public string CardNumber {  get; set; }
        public string CardType {  get; set; }
        public string BillingAddress {  get; set; }
        public string BillingCity { get; set;}
        public string BillingCountry { get; set;}
    }
}
