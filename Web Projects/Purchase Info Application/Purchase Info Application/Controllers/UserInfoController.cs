using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Data;

namespace Purchase_Info_Application.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class UserInfoController : Controller
    {
        private readonly UserDbContext _userDbContext;
        public UserInfoController(UserDbContext userDbContext)
        {
            _userDbContext = userDbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllUsers()
        {
            return Ok(await _userDbContext.Users.ToListAsync());
        }
    }
}
