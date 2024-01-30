namespace Notes.API.Models.Entities
{
    public class Note
    {

        public Guid Id { get; set; }

        public String Title { get; set; }

        public String Description { get; set; }

        public bool IsVisible { get; set; }
    }
}
