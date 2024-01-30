using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Notes.API.Data;
using Notes.API.Models.Entities;

namespace Notes.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class NotesController : Controller
    {
        private readonly NotesDbContext dbContext;
        public NotesController(NotesDbContext context)
        {
            this.dbContext = context;
        }
        [HttpGet]
        public async Task<IActionResult> GetAllNotes()
        {
            //Get the notes from the database
            return Ok(await dbContext.Notes.ToListAsync());
        }

        [HttpGet]
        [Route("{id:Guid}")]
        [ActionName("GetNoteById")]
        public async Task<IActionResult> GetNoteById([FromRoute] Guid id)
        {
            //await dbContext.Notes.FirstOrDefaultAsync(x => x.Id == id);
            //or
            var note = await dbContext.Notes.FindAsync(id);
            if (note == null)
            {
                return NotFound();
            }

            return Ok(note);
        }

        [HttpPost]
        public async Task<IActionResult> AddNote(Note note)
        {
            note.Id = Guid.NewGuid();
            await dbContext.Notes.AddAsync(note);
            await dbContext.SaveChangesAsync();

            return CreatedAtAction(nameof(GetNoteById), new {id = note.Id}, note);
        }

        [HttpPut]
        [Route("{id:Guid}")]
        public async Task<IActionResult> UpdateNote([FromRoute] Guid id, [FromBody] Note updatedNote)
        {
            var existingNote = await dbContext.Notes.FindAsync(id);

            if (existingNote == null)
            {
                return NotFound();
            }

            existingNote.Title = updatedNote.Title;
            existingNote.Description = updatedNote.Description; 
            existingNote.IsVisible = updatedNote.IsVisible;

            await dbContext.SaveChangesAsync();
            
            return Ok(existingNote);
        }

        [HttpDelete]
        [Route("{id:Guid}")]
        public async Task<IActionResult> DeleteNote([FromRoute] Guid id)
        {
            var existingNote = await dbContext.Notes.FindAsync(id);

            if (existingNote == null)
            {
                return NotFound();
            }

            dbContext.Notes.Remove(existingNote);
            await dbContext.SaveChangesAsync();

            return Ok();

        }
    }
}
