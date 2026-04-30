# QuickFix 🔧

> Find skilled professionals near you — instantly.

---

## What is QuickFix?

So basically, I got tired of spending 2 hours scrolling through random contacts trying to find a decent plumber when my bathroom decided to flood at 11pm. That's how QuickFix was born.

QuickFix connects you with trusted local service professionals — barbers, cleaners, painters, carpenters, plumbers, mechanics — whatever you need, whenever you need it. No middlemen, no endless searching. Just open the app, pick a service, and see who's available near you along with their contact details. Simple as that.

---

## Services We Cover

- 💈 **Barber** — Haircuts, beard trims, grooming — at your doorstep or nearby
- 🧹 **Cleaner** — Home cleaning, deep cleaning, post-renovation cleanup
- 🖌️ **Painter** — Wall painting, touch-ups, full room makeovers
- 🪚 **Carpenter** — Furniture repair, custom woodwork, installations
- 🔧 **Plumber** — Leaks, pipe fitting, bathroom/kitchen repairs
- 🔩 **Mechanic** — Vehicle repairs, servicing, on-road breakdowns

More categories coming soon — this is just the beginning.

---

## How It Works

1. **Open QuickFix** and allow location access
2. **Pick a service** you need (plumber, barber, etc.)
3. **Browse nearby professionals** with ratings and availability
4. **Get their contact details** — call or message them directly
5. **Done.** No complicated booking flows, no hidden fees

---

## Tech Stack

Here's what's powering QuickFix under the hood:

| Layer | Tech |
|---|---|
| Frontend | React Native |
| Backend | Springboot + RestAPI |
| Database | MySQL |
| Location | Google Maps API |
| Auth | 

> Note: This is just the initial stack. Things might change as we scale.

---

## Getting Started (Local Setup)

```bash
# Clone the repo
git clone https://github.com/yourusername/quickfix.git

# Go into the project
cd quickfix

# Install dependencies
npm install

# Set up your environment variables
cp .env.example .env
# Fill in your API keys (Google Maps, Firebase, etc.)

# Run the dev server
npm run dev
```

Make sure you have Node.js v18+ and MongoDB running locally before you start.

---

## Environment Variables

Create a `.env` file in the root directory and add these:

```
PORT=5000
MONGO_URI=your_mongodb_connection_string
GOOGLE_MAPS_API_KEY=your_google_maps_key
FIREBASE_API_KEY=your_firebase_key
JWT_SECRET=your_jwt_secret
```

Don't commit your `.env` file. It's already in `.gitignore` but just... don't.

---

## Features (Current + Planned)

### ✅ Live Right Now
- Location-based professional search
- Service category filtering
- Professional profiles with ratings
- Direct contact details (phone/WhatsApp)
- User authentication

### 🚧 In Progress
- In-app booking & scheduling
- Real-time chat
- Payment integration (Razorpay/UPI)
- Review & rating system

### 🔮 Future Plans
- Professional verification badges
- Subscription plans for frequent users
- Emergency/priority service booking
- Multi-city expansion

## Contributing

Honestly, any help is welcome. If you find a bug, have a feature idea, or just want to improve something — go ahead and open an issue or send a PR.

1. Fork the repo
2. Create your branch (`git checkout -b feature/cool-thing`)
3. Commit your changes (`git commit -m 'add cool thing'`)
4. Push to the branch (`git push origin feature/cool-thing`)
5. Open a Pull Request

Try to keep commits clean and meaningful. No "fixed stuff" commit messages please 😅

---

## Known Issues

- Location sometimes takes a few seconds to load on older Android devices
- Professional list doesn't auto-refresh without a manual pull-down (working on it)
- Dark mode is still WIP

---

## Screenshots

> Coming soon — UI is still getting polished. Watch this space.

---

## License

MIT — use it, modify it, do whatever. Just don't resell it as your own product without contributing back. That's just bad karma.

---

## Contact

Built by Yogendra Singh
- Email: yogendrasingh4987@gmail.com
- LinkedIn: https://www.linkedin.com/in/yogendrasingh02/

If you're using QuickFix for something cool, I'd genuinely love to know. Drop me a message.

---

*QuickFix — because finding a good plumber shouldn't be this hard.*
