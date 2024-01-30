using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Data;
using Purchase_Info_Application.Models.Entities;

namespace Purchase_Info_Application.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class LoginController : Controller
    {
        private readonly UserDbContext _userDbContext;
        public LoginController(UserDbContext userDbContext)
        {
            _userDbContext = userDbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllUsers()
        {
            return Ok(await _userDbContext.Users.ToListAsync());
        }

        [HttpPost]
        public async Task<IActionResult> AddUsers(List<User> users)
        {
            foreach(User user in users)
            {
                await _userDbContext.Users.AddAsync(user); 
            };
            await _userDbContext.SaveChangesAsync();


            return Ok();
        }
    }
}
