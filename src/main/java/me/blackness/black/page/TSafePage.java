package me.blackness.black.page;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;

import me.blackness.black.Page;
import me.blackness.black.Pane;

/*
       .                                                    .
    .$"                                    $o.      $o.  _o"
   .o$$o.    .o$o.    .o$o.    .o$o.   .o$$$$$  .o$$$$$ $$P  `4$$$$P'   .o$o.
  .$$| $$$  $$' $$$  $$' $$$  $$' $$$ $$$| $$$ $$$| $$$ ($o  $$$: $$$  $$' $$$
  """  """ """  """ """  """ """  """ """  """ """  """  "   """  """ """  """
.oOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOo.
  ooo_ ooo ooo. ... ooo. ... ooo.  .. `4ooo.  .`4ooo.   ooo. ooo. ooo ooo.  ..
  $$$"$$$$ $$$| ... $$$| ... $$$$$$ ..    "$$o     "$$o $$$| $$$| $$$ $$$|   .
  $$$| $$$ $$$|     $$$|     $$$|     $$$: $$$ $$$: $$$ $$$| $$$| $$$ $$$|
  $$$| $$$ $$$| $o. $$$| $o. $$$| $o. $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $.
  $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $o.
  $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $$$
  $$$| $$$  $$. $$$  $$. $$$  $$. $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$  $$. $$$
  $$$: $P'  `4$$$Ü'__`4$$$Ü'  `4$$$Ü' $$$$$P'  $$$$$P'  $$$| $$$: $P' __`4$$$Ü'
 _ _______/∖______/  ∖______/∖______________/|________ "$P' _______/  ∖_____ _
                                                        i"  personinblack
                                                        |
 */

/**
 * thread-safe decorator for any page.
 *
 * @see Page
 */
public class TSafePage implements Page {
    private final Page basePage;

    /**
     * ctor.
     *
     * @param basePage the page to make thread-safe
     */
    public TSafePage(final Page basePage) {
        this.basePage = basePage;
    }

    @Override
    public void add(final Pane pane, final int position) {
        synchronized (basePage) {
            basePage.add(pane, position);
        }
    }

    @Override
    public void remove(final int position) {
        synchronized (basePage) {
            basePage.remove(position);
        }
    }

    @Override
    public void rearrange(final Map<Integer, Integer> arrangements) {
        synchronized (basePage) {
            basePage.rearrange(arrangements);
        }
    }

    @Override
    public void showTo(final Player player) {
        synchronized (basePage) {
            basePage.showTo(player);
        }
    }

    @Override
    public void handleClose(final InventoryCloseEvent event) {
        synchronized (basePage) {
            basePage.handleClose(event);
        }
    }

    @Override
    public void update(final Object argument) {
        synchronized (basePage) {
            basePage.update(argument);
        }
    }

    /**
     * {@inheritDoc}
     * @deprecated because this is against oop and we don't have a single universal inventory.
     */
    @Override @Deprecated
    public Inventory getInventory() {
        return basePage.getInventory();
    }

    @Override
    public void accept(final InventoryInteractEvent event) {
        synchronized (basePage) {
            basePage.accept(event);
        }
    }
}
