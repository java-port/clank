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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Pair$_U1$_U2;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$Deref;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


/// This class provides a symbol table of name/value pairs. It is essentially
/// a std::map<std::string,Value*> but has a controlled interface provided by
/// LLVM as well as ensuring uniqueness of names.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 34,
 FQN="llvm::ValueSymbolTable", NM="_ZN4llvm16ValueSymbolTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTableE")
//</editor-fold>
public class ValueSymbolTable implements Iterable<StringMapEntry<Value /*P*/ >>, Destructors.ClassWithDestructor {
  /*friend  class Value*/
  /*friend  class SymbolTableListTraits<Argument>*/
  /*friend  class SymbolTableListTraits<BasicBlock>*/
  /*friend  class SymbolTableListTraits<Instruction>*/
  /*friend  class SymbolTableListTraits<Function>*/
  /*friend  class SymbolTableListTraits<GlobalVariable>*/
  /*friend  class SymbolTableListTraits<GlobalAlias>*/
  /*friend  class SymbolTableListTraits<GlobalIFunc>*/
/// @name Types
  /// @{
  /*public:*/
  /// @brief A mapping of names to values.
  // JAVA: typedef StringMap<Value *> ValueMap
//  public final class ValueMap extends StringMap<Value /*P*/ >{ };
  
  /// @brief An iterator over a ValueMap.
  // JAVA: typedef ValueMap::iterator iterator
//  public final class iterator extends StringMapIterator<Value /*P*/ >{ };
  
  /// @brief A const_iterator over a ValueMap.
  // JAVA: typedef ValueMap::const_iterator const_iterator
//  public final class const_iterator extends StringMapConstIterator<Value /*P*/ >{ };

  /// @}
  /// @name Constructors
  /// @{
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::ValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 59,
   FQN="llvm::ValueSymbolTable::ValueSymbolTable", NM="_ZN4llvm16ValueSymbolTableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTableC1Ev")
  //</editor-fold>
  public ValueSymbolTable() {
    // : vmap(0), LastUnique(0) 
    //START JInit
    this.vmap = new StringMap<Value /*P*/ >(0, (Value /*P*/ )null);
    this.LastUnique = 0;
    //END JInit
  }

  
  // Class destructor
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::~ValueSymbolTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 25,
   FQN="llvm::ValueSymbolTable::~ValueSymbolTable", NM="_ZN4llvm16ValueSymbolTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTableD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Only do this in -g mode...
    for (final /*const*/ StringMapEntry<Value /*P*/ > /*&*/ VI : vmap)  {
      IrLlvmGlobals.$out_raw_ostream_Type(dbgs().$out(/*KEEP_STR*/"Value still in symbol table! Type = '"), 
          $Deref(VI.getValue$Const().getType())).$out(/*KEEP_STR*/"' Name = '").$out(VI.getKeyData()).$out(
          /*KEEP_STR*/"'\n"
      );
    }
    assert (vmap.empty()) : "Values remain in symbol table!";
    //START JDestroy
    vmap.$destroy();
    //END JDestroy
  }


  /// @}
  /// @name Accessors
  /// @{
  /*public:*/
  /// This method finds the value with the given \p Name in the
  /// the symbol table.
  /// @returns the value associated with the \p Name
  /// @brief Lookup a named Value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 70,
   FQN="llvm::ValueSymbolTable::lookup", NM="_ZNK4llvm16ValueSymbolTable6lookupENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable6lookupENS_9StringRefE")
  //</editor-fold>
  public Value /*P*/ lookup(StringRef Name) /*const*/ {
    return vmap.lookup(new StringRef(Name));
  }

  
  /// @returns true iff the symbol table is empty
  /// @brief Determine if the symbol table is empty
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 74,
   FQN="llvm::ValueSymbolTable::empty", NM="_ZNK4llvm16ValueSymbolTable5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable5emptyEv")
  //</editor-fold>
  public /*inline*/ boolean empty() /*const*/ {
    return vmap.empty();
  }

  
  /// @brief The number of name/type pairs is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 77,
   FQN="llvm::ValueSymbolTable::size", NM="_ZNK4llvm16ValueSymbolTable4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable4sizeEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int size() /*const*/ {
    return ((/*uint*/int)(vmap.size()));
  }

  
  /// This function can be used from the debugger to display the
  /// content of the symbol table while debugging.
  /// @brief Print out symbol table on stderr
  
  // dump - print out the symbol table
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 100,
   FQN="llvm::ValueSymbolTable::dump", NM="_ZNK4llvm16ValueSymbolTable4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    //DEBUG(dbgs() << "ValueSymbolTable:\n");
    for (final /*const*/ StringMapEntry<Value /*P*/ > /*&*/ I : /*Deref*/this) {
      //DEBUG(dbgs() << "  '" << I->getKeyData() << "' = ");
      I.getValue$Const().dump();
      //DEBUG(dbgs() << "\n");
    }
  }


  /// @}
  /// @name Iteration
  /// @{
  /*public:*/
  /// @brief Get an iterator that from the beginning of the symbol table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 89,
   FQN="llvm::ValueSymbolTable::begin", NM="_ZN4llvm16ValueSymbolTable5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable5beginEv")
  //</editor-fold>
  public /*inline*/ StringMapIterator<Value /*P*/ > begin() {
    return vmap.begin();
  }

  
  /// @brief Get a const_iterator that from the beginning of the symbol table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 92,
   FQN="llvm::ValueSymbolTable::begin", NM="_ZNK4llvm16ValueSymbolTable5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable5beginEv")
  //</editor-fold>
  public /*inline*/ StringMapConstIterator<Value /*P*/ > begin$Const() /*const*/ {
    return vmap.begin$Const();
  }

  
  /// @brief Get an iterator to the end of the symbol table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 95,
   FQN="llvm::ValueSymbolTable::end", NM="_ZN4llvm16ValueSymbolTable3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable3endEv")
  //</editor-fold>
  public /*inline*/ StringMapIterator<Value /*P*/ > end() {
    return vmap.end();
  }

  
  /// @brief Get a const_iterator to the end of the symbol table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ValueSymbolTable.h", line = 98,
   FQN="llvm::ValueSymbolTable::end", NM="_ZNK4llvm16ValueSymbolTable3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZNK4llvm16ValueSymbolTable3endEv")
  //</editor-fold>
  public /*inline*/ StringMapConstIterator<Value /*P*/ > end$Const() /*const*/ {
    return vmap.end$Const();
  }


  /// @}
  /// @name Mutators
  /// @{
  /*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::makeUniqueName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 35,
   FQN="llvm::ValueSymbolTable::makeUniqueName", NM="_ZN4llvm16ValueSymbolTable14makeUniqueNameEPNS_5ValueERNS_11SmallStringILj256EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable14makeUniqueNameEPNS_5ValueERNS_11SmallStringILj256EEE")
  //</editor-fold>
  private StringMapEntry<Value /*P*/ > /*P*/ makeUniqueName(Value /*P*/ V, 
                final SmallString/*<256>*/ /*&*/ UniqueName) {
    /*uint*/int BaseSize = UniqueName.size();
    while (true) {
      raw_svector_ostream S = null;
      try {
        // Trim any suffix off and append the next number.
        UniqueName.resize(BaseSize);
        S/*J*/= new raw_svector_ostream(UniqueName);
        if (isa_GlobalValue(V)) {
          S.$out(/*KEEP_STR*/$DOT);
        }
        S.$out_uint(++LastUnique);
        
        // Try insert the vmap entry with this suffix.
        std.pairTypeBool<StringMapIterator<Value /*P*/ >> IterBool = vmap.insert(new std.pairTypePtr<StringRef, Value /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, /*Fwd*/new SmallString/*<256>*/(/*Fwd2*/UniqueName).$StringRef(), /*Fwd2*//*Fwd*/V));
        if (IterBool.second) {
          return $AddrOf(IterBool.first.$star());
        }
      } finally {
        if (S != null) { S.$destroy(); }
      }
    }
  }

  
  /// This method adds the provided value \p N to the symbol table.  The Value
  /// must have a name which is used to place the value in the symbol table.
  /// If the inserted name conflicts, this renames the value.
  /// @brief Add a named value to the symbol table
  
  // Insert a value into the symbol table with the specified name...
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::reinsertValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 55,
   FQN="llvm::ValueSymbolTable::reinsertValue", NM="_ZN4llvm16ValueSymbolTable13reinsertValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable13reinsertValueEPNS_5ValueE")
  //</editor-fold>
  /*friend*/ public/*private*/ void reinsertValue(Value /*P*/ V) {
    assert (V.hasName()) : "Can't insert nameless Value into symbol table";
    
    // Try inserting the name, assuming it won't conflict.
    if (vmap.insert(V.getValueName())) {
      //DEBUG(dbgs() << " Inserted value: " << V->getValueName() << ": " << *V << "\n");
      return;
    }
    
    // Otherwise, there is a naming conflict.  Rename this value.
    SmallString/*<256>*/ UniqueName/*J*/= new SmallString/*<256>*/(V.getName().begin(), V.getName().end(), 256);
    
    // The name is too already used, just free it so we can allocate a new name.
    V.getValueName().Destroy();
    
    StringMapEntry<Value /*P*/ > /*P*/ VN = makeUniqueName(V, UniqueName);
    V.setValueName(VN);
  }

  
  /// createValueName - This method attempts to create a value name and insert
  /// it into the symbol table with the specified name.  If it conflicts, it
  /// auto-renames the name and returns that instead.
  
  /// createValueName - This method attempts to create a value name and insert
  /// it into the symbol table with the specified name.  If it conflicts, it
  /// auto-renames the name and returns that instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::createValueName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 83,
   FQN="llvm::ValueSymbolTable::createValueName", NM="_ZN4llvm16ValueSymbolTable15createValueNameENS_9StringRefEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable15createValueNameENS_9StringRefEPNS_5ValueE")
  //</editor-fold>
  /*friend*//*private*/ StringMapEntry<Value /*P*/ > /*P*/ createValueName(StringRef Name, Value /*P*/ V) {
    // In the common case, the name is not already in the symbol table.
    std.pairTypeBool<StringMapIterator<Value /*P*/ >> IterBool = vmap.insert(std.make_pair_T_Ptr($Clone(Name), V));
    if (IterBool.second) {
      //DEBUG(dbgs() << " Inserted value: " << Entry.getKeyData() << ": "
      //           << *V << "\n");
      return $AddrOf(IterBool.first.$star());
    }
    
    // Otherwise, there is a naming conflict.  Rename this value.
    SmallString/*<256>*/ UniqueName/*J*/= new SmallString/*<256>*/(Name.begin(), Name.end(), 256);
    return makeUniqueName(V, UniqueName);
  }

  
  /// This method removes a value from the symbol table.  It leaves the
  /// ValueName attached to the value, but it is no longer inserted in the
  /// symtab.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueSymbolTable::removeValueName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp", line = 74,
   FQN="llvm::ValueSymbolTable::removeValueName", NM="_ZN4llvm16ValueSymbolTable15removeValueNameEPNS_14StringMapEntryIPNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ValueSymbolTable.cpp -nm=_ZN4llvm16ValueSymbolTable15removeValueNameEPNS_14StringMapEntryIPNS_5ValueEEE")
  //</editor-fold>
  /*friend*/ public/*private*/ void removeValueName(StringMapEntry<Value /*P*/ > /*P*/ V) {
    //DEBUG(dbgs() << " Removing Value: " << V->getKeyData() << "\n");
    // Remove the value from the symbol table.
    vmap.remove(V);
  }


  /// @}
  /// @name Internal Data
  /// @{
  /*private:*/
  private StringMap<Value /*P*/ > vmap; ///< The map that holds the symbol table.
  private /*mutable *//*uint32_t*/int LastUnique; ///< Counter for tracking unique names
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public Iterator<StringMapEntry<Value /*P*/ >> iterator() { return new JavaIterator<StringMapEntry<Value /*P*/ >>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "vmap=" + vmap.size() // NOI18N
              + ", LastUnique=" + LastUnique; // NOI18N
  }
/// @}
}
