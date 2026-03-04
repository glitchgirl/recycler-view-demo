# recycler-view-demo
Here’s a **small, fun RecyclerView demo** you can use in class 🎉
It’s simple, visual, and easy for students to expand.

We’ll build:

> 🐶 **“Pet Adoption List”** – A scrolling list of pets with name + description.

---

# 🐶 RecyclerView Demo – Pet Adoption List

---

## 1️⃣ What Students Will Learn

* What a `RecyclerView` is
* How adapters work
* How ViewHolders work
* How data connects to UI
* Basic click handling
---
# Set up
📱 In Android Studio:

Click New Project

Choose Empty Views Activity

Click Next

Configure:

Name: RecyclerViewDemo

Language: Kotlin

Minimum SDK: API 24 (or whatever your class is using)

Click Finish

---

# Step 1: Add RecyclerView Dependency

In `app/build.gradle`:

```gradle
dependencies {
    implementation("androidx.recyclerview:recyclerview:1.3.2")
}
```

---

# Step 2: Add RecyclerView to Layout

### `activity_main.xml`
app
└── src
    └── main
        └── res
            └── layout
                └── activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.recyclerview.widget.RecyclerView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/recyclerView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

# Step 3: Create a Data Class
The same folder as the MainActivity.kt
### `Pet.kt`

```kotlin
data class Pet(
    val name: String,
    val description: String
)
```

---

# Step 4: Create Item Layout
The same folder as activity_main.xml
### `item_pet.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/tvName"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <TextView
        android:id="@+id/tvDescription"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

---

# Step 5: Create the Adapter
app
└── src
    └── main
        └── java
            └── your.package.name
                ├── MainActivity.kt
                ├── Pet.kt       ← data class
                └── PetAdapter.kt ← adapter
### `PetAdapter.kt`

```kotlin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(private val petList: List<Pet>) :
    RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = petList[position]
        holder.name.text = pet.name
        holder.description.text = pet.description

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You clicked ${pet.name}!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = petList.size
}
```

---

# Step 6: Connect Everything in MainActivity

### `MainActivity.kt`

```kotlin
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val pets = listOf(
            Pet("Bella", "Loves belly rubs 🐶"),
            Pet("Max", "Enjoys long walks in the park 🌳"),
            Pet("Luna", "Professional napper 😴"),
            Pet("Charlie", "Fetch champion 🥎"),
            Pet("Daisy", "Snack enthusiast 🦴")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PetAdapter(pets)
    }
}
```

---

# 🎯 Teaching Talking Points

You can explain RecyclerView like this:

* **RecyclerView = Manager**
* **Adapter = Translator**
* **ViewHolder = Reusable box**
* **LayoutManager = Organizer**

Ask students:

* What happens if we add 1,000 pets?
* Why don’t we create 1,000 views?
* Where is the recycling happening?

---

# 🚀 Easy Extensions (For Extra Fun)

1. Add an image (use `ImageView`)
2. Change to GridLayoutManager
3. Add a “favorite” button
4. Use DiffUtil
5. Convert to Compose LazyColumn version

---
