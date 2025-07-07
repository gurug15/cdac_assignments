using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using StudentMVC.Models;

namespace StudentMVC.Controllers
{
    public class StudentMarksController : Controller
    {
        private readonly ExamContext _context;

        public StudentMarksController(ExamContext context)
        {
            _context = context;
        }

        // GET: StudentMarks
        public async Task<IActionResult> Index()
        {
            var examContext = _context.StudentMarks.Include(s => s.Student);
            return View(await examContext.ToListAsync());
        }

        // GET: StudentMarks/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentMark = await _context.StudentMarks
                .Include(s => s.Student)
                .FirstOrDefaultAsync(m => m.Id == id);
            if (studentMark == null)
            {
                return NotFound();
            }

            return View(studentMark);
        }

        // GET: StudentMarks/Create
        public IActionResult Create()
        {
            ViewData["StudentId"] = new SelectList(_context.Students, "RollNo", "Name");

            //ViewData["StudentId"] = new SelectList(_context.Students, "RollNo", "RollNo");
            return View();
        }

        // POST: StudentMarks/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,StudentId,Subject,Marks")] StudentMark studentMark)
        {
            
            Console.WriteLine("before Validating");
            if (ModelState.IsValid)
            {
                Console.WriteLine("inserting");
                _context.Add(studentMark);
                await _context.SaveChangesAsync();
                Console.WriteLine("inserted");
                return RedirectToAction(nameof(Index));
            }
            ViewData["StudentId"] = new SelectList(_context.Students, "RollNo", "RollNo", studentMark.StudentId);
            return View(studentMark);
        }

        // GET: StudentMarks/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentMark = await _context.StudentMarks.FindAsync(id);
            if (studentMark == null)
            {
                return NotFound();
            }
            ViewData["StudentId"] = new SelectList(_context.Students, "RollNo", "RollNo", studentMark.StudentId);
            return View(studentMark);
        }

        // POST: StudentMarks/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,StudentId,Subject,Marks")] StudentMark studentMark)
        {
            if (id != studentMark.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(studentMark);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!StudentMarkExists(studentMark.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            ViewData["StudentId"] = new SelectList(_context.Students, "RollNo", "RollNo", studentMark.StudentId);
            return View(studentMark);
        }

        // GET: StudentMarks/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentMark = await _context.StudentMarks
                .Include(s => s.Student)
                .FirstOrDefaultAsync(m => m.Id == id);
            if (studentMark == null)
            {
                return NotFound();
            }

            return View(studentMark);
        }

        // POST: StudentMarks/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var studentMark = await _context.StudentMarks.FindAsync(id);
            if (studentMark != null)
            {
                _context.StudentMarks.Remove(studentMark);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool StudentMarkExists(int id)
        {
            return _context.StudentMarks.Any(e => e.Id == id);
        }
    }
}
