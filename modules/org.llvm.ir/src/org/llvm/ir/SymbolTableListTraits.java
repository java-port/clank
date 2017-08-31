/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.ir.java.*;
import org.llvm.ir.java.IChild;


// ValueSubClass   - The type of objects that I hold, e.g. Instruction.
// ItemParentClass - The type of object that owns the list, e.g. BasicBlock.
//
/*template <typename ValueSubClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 70,
 FQN="llvm::SymbolTableListTraits", NM="_ZN4llvm21SymbolTableListTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraitsE")
//</editor-fold>
public interface SymbolTableListTraits</*typename*/ ValueSubClass extends Value & ilist_node<ValueSubClass> & IChild<ItemParentClass>, ItemParentClass extends IValueSymbolTableProvider>
        extends /*public*/ ilist_nextprev_traits<ValueSubClass>, /*public*/ SymbolTableListSentinelTraits<ValueSubClass>, /*public*/ ilist_node_traits<ValueSubClass>, ilist_traits<ValueSubClass> {
  // JAVA: typedef SymbolTableList<ValueSubClass> ListTy
//  public final class ListTy extends SymbolTableList<ValueSubClass>{ };
  // JAVA: typedef typename SymbolTableListParentType<ValueSubClass>::type ItemParentClass
//  public final class ItemParentClass extends  SymbolTableListParentType.type<ValueSubClass>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::SymbolTableListTraits<NodeTy>">
//  @Converted(kind = Converted.Kind.MANUAL,
//   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 80,
//   FQN="llvm::SymbolTableListTraits::SymbolTableListTraits<NodeTy>", NM="_ZN4llvm21SymbolTableListTraitsC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraitsC1Ev")
//  //</editor-fold>
//  public default/*interface*/ void $SymbolTableListTraits() {
//  }

/*private:*/
  /// getListOwner - Return the object that owns this list.  If this is a list
  /// of instructions, it returns the BasicBlock that owns them.
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::getListOwner">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 85,
   FQN="llvm::SymbolTableListTraits::getListOwner", NM="_ZN4llvm21SymbolTableListTraits12getListOwnerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits12getListOwnerEv")
  //</editor-fold>
  /*private*/ default ItemParentClass/*P*/ getListOwner(iplist</*typename*/ ValueSubClass /*P*/> list) {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::getList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 93,
   FQN="llvm::SymbolTableListTraits::getList", NM="_ZN4llvm21SymbolTableListTraits7getListEPNS_25SymbolTableListParentTypeIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits7getListEPNS_25SymbolTableListParentTypeIT_E4typeE")
  //</editor-fold>
  /*private*/ default SymbolTableList<ValueSubClass, ItemParentClass> /*&*/ getList(ItemParentClass/*P*/ Par, Class<? extends ValueSubClass> childClass) {
    //return Par ->* (Par.getSublistAccess((ValueSubClass /*P*/ )null));
    return ISublistAccessProvider.getSublistAccessProvider(null, childClass).$call(Par);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::getSymTab">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 97,
   FQN="llvm::SymbolTableListTraits::getSymTab", NM="_ZN4llvm21SymbolTableListTraits9getSymTabEPNS_25SymbolTableListParentTypeIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.ll vm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits9getSymTabEPNS_25SymbolTableListParentTypeIT_E4typeE")
  //</editor-fold>
  /*private*/ default ValueSymbolTable /*P*/ getSymTab(ItemParentClass /*P*/ Par) {
    return $bool(Par) ? Par.getValueSymbolTable() : null;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::addNodeToList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/SymbolTableListTraitsImpl.h", line = 63,
   FQN="llvm::SymbolTableListTraits::addNodeToList", NM="_ZN4llvm21SymbolTableListTraits13addNodeToListEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits13addNodeToListEPT_")
  //</editor-fold>
  public default void addNodeToList(iplist</*typename*/ ValueSubClass /*P*/> list, ValueSubClass /*P*/ V) {
    assert Native.$bool(Native.$not(V.getParent())) : "Value already in a container!!";
    ItemParentClass/*P*/ Owner = getListOwner(list);
    V.setParent(Owner);
    if (V.hasName()) {
      {
        ValueSymbolTable /*P*/ ST = getSymTab(Owner);
        if ((ST != null)) {
          ST.reinsertValue(V);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::removeNodeFromList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/SymbolTableListTraitsImpl.h", line = 73,
   FQN="llvm::SymbolTableListTraits::removeNodeFromList", NM="_ZN4llvm21SymbolTableListTraits18removeNodeFromListEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits18removeNodeFromListEPT_")
  //</editor-fold>
  public default void removeNodeFromList(iplist</*typename*/ ValueSubClass /*P*/> list, ValueSubClass /*P*/ V) {
    V.setParent(null);
    if (V.hasName()) {
      {
        ValueSymbolTable /*P*/ ST = getSymTab(getListOwner(list));
        if ((ST != null)) {
          ST.removeValueName(V.getValueName());
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::transferNodesFromList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/SymbolTableListTraitsImpl.h", line = 82,
   FQN="llvm::SymbolTableListTraits::transferNodesFromList", NM="_ZN4llvm21SymbolTableListTraits21transferNodesFromListERNS_21SymbolTableListTraitsIT_EENS_14ilist_iteratorIS2_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits21transferNodesFromListERNS_21SymbolTableListTraitsIT_EENS_14ilist_iteratorIS2_EES7_")
  //</editor-fold>
  public default void transferNodesFromList(final SymbolTableListTraits<ValueSubClass, ItemParentClass> /*&*/ L2, ilist_iterator<ValueSubClass> first, 
                       ilist_iterator<ValueSubClass> last) {
    // We only have to do work here if transferring instructions between BBs
    ItemParentClass/*P*/ NewIP = getListOwner(/*TODO*/null);
    ItemParentClass/*P*/ OldIP = L2.getListOwner(/*TODO*/null);
    if (Native.$eq(NewIP, OldIP)) {
      return; // No work to do at all...
    }

    // We only have to update symbol table entries if we are transferring the
    // instructions to a different symtab object...
    ValueSymbolTable /*P*/ NewST = getSymTab(NewIP);
    ValueSymbolTable /*P*/ OldST = getSymTab(OldIP);
    if (NewST != OldST) {
      for (; Native.$noteq_iter(first, last); first.$preInc()) {
        final ValueSubClass /*&*/ V = first.$star();
        boolean HasName = V.hasName();
        if ((OldST != null) && HasName) {
          OldST.removeValueName(V.getValueName());
        }
        V.setParent(NewIP);
        if ((NewST != null) && HasName) {
          NewST.reinsertValue($AddrOf(V));
        }
      }
    } else {
      // Just transferring between blocks in the same function, simply update the
      // parent fields in the instructions...
      for (; Native.$noteq_iter(first, last); first.$preInc())  {
        first.$arrow().setParent(NewIP);
      }
    }
  }

  //private:
  /*template <typename TPtr> TEMPLATE*/
  
  /// setSymTabObject - This is called when (f.e.) the parent of a basic block
  /// changes.  This requires us to remove all the instruction symtab entries from
  /// the current function and reinsert them into the new function.
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::setSymTabObject">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/SymbolTableListTraitsImpl.h", line = 27,
   FQN="llvm::SymbolTableListTraits::setSymTabObject", NM="Tpl__ZN4llvm21SymbolTableListTraits15setSymTabObjectEPT_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm21SymbolTableListTraits15setSymTabObjectEPT_S1_")
  //</editor-fold>
  public default </*typename*/ TPtr> void setSymTabObject(iplist</*typename*/ ValueSubClass /*P*/> list, type$ptr<TPtr> /*P*/ Dest, 
                 TPtr Src) {
    // Get the old symtab and value list before doing the assignment.
    ValueSymbolTable /*P*/ OldST = getSymTab(getListOwner(list));
    
    // Do it.
    Dest.$set(Src);
    
    // Get the new SymTab object.
    ValueSymbolTable /*P*/ NewST = getSymTab(getListOwner(list));
    
    // If there is nothing to do, quick exit.
    if (OldST == NewST) {
      return;
    }

    // Move all the elements from the old symtab to the new one.
    final SymbolTableList<ValueSubClass, ItemParentClass> /*&*/ ItemList = getList(getListOwner(list), $getValueSubClass());
    if (ItemList.empty()) {
      return;
    }
    if ((OldST != null)) {
      // Remove all entries from the previous symtab.
      for (/*<dependent type>*/ilist_iterator<ValueSubClass> I = ItemList.begin(); Native.$noteq_iter(I, ItemList.end()); I.$preInc())  {
        if (I.$star().hasName()) {
          OldST.removeValueName(I.$star().getValueName());
        }
      }
    }
    if ((NewST != null)) {
      // Add all of the items to the new symtab.
      for (/*<dependent type>*/ilist_iterator<ValueSubClass> I = ItemList.begin(); Native.$noteq_iter(I, ItemList.end()); I.$preInc())  {
        if (I.$star().hasName()) {
          NewST.reinsertValue(I.$star());
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 110,
   FQN="llvm::SymbolTableListTraits::toPtr", NM="_ZN4llvm21SymbolTableListTraits5toPtrEPNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits5toPtrEPNS_16ValueSymbolTableE")
  //</editor-fold>
  public /*interface*/ static </*typename*/ ValueSubClass> ValueSymbolTable /*P*/ toPtr_ValueSymbolTable$P(ValueSymbolTable /*P*/ P) {
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 111,
   FQN="llvm::SymbolTableListTraits::toPtr", NM="_ZN4llvm21SymbolTableListTraits5toPtrERNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm21SymbolTableListTraits5toPtrERNS_16ValueSymbolTableE")
  //</editor-fold>
  public /*interface*/ static </*typename*/ ValueSubClass> ValueSymbolTable /*P*/ toPtr_ValueSymbolTable(final ValueSymbolTable /*&*/ R) {
    return $AddrOf(R);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  Class<ValueSubClass> $getValueSubClass();

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
