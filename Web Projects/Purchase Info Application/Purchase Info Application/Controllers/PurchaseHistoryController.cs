using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Purchase_Info_Application.Data;
using Purchase_Info_Application.Models.Entities;

namespace Purchase_Info_Application.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PurchaseHistoryController : Controller
    {
        private readonly TransactionDbContext _transactionDbContext;
        public PurchaseHistoryController(TransactionDbContext transactionDbContext)
        {
            _transactionDbContext = transactionDbContext;
        }

        [HttpGet]
        public async Task<IActionResult> GetAllTransactions()
        {
            return Ok(await _transactionDbContext.Transactions.ToListAsync());
        }

        [HttpPost]
        public async Task<IActionResult> AddTransactions(List<Transaction> transactions)
        {
            foreach (Transaction transaction in transactions)
            {
                await _transactionDbContext.Transactions.AddAsync(transaction);
            };
            await _transactionDbContext.SaveChangesAsync();


            return Ok();
        }
    }
}
