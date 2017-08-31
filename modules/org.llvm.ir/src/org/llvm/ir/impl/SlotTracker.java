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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;

//===----------------------------------------------------------------------===//
// SlotTracker Class: Enumerate slot numbers for unnamed values
//===----------------------------------------------------------------------===//
/// This class provides computation of slot numbers for LLVM Assembly writing.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 580,
 FQN="llvm::SlotTracker", NM="_ZN4llvm11SlotTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackerE")
//</editor-fold>
public class SlotTracker implements Destructors.ClassWithDestructor {
/*public:*/
  /// ValueMap - A mapping of Values to slot numbers.
  // JAVA: typedef DenseMap<const Value *, unsigned int> ValueMap
//  public final class ValueMap extends DenseMapTypeUInt</*const*/ Value /*P*/ >{ };
/*private:*/
  /// TheModule - The module for which we are holding slot numbers.
  private /*const*/ Module /*P*/ TheModule;
  
  /// TheFunction - The function for which we are holding slot numbers.
  private /*const*/ Function /*P*/ TheFunction;
  private boolean FunctionProcessed;
  private boolean ShouldInitializeAllMetadata;
  
  /// mMap - The slot map for the module level data.
  private DenseMapTypeUInt</*const*/ Value /*P*/ > mMap;
  private /*uint*/int mNext;
  
  /// fMap - The slot map for the function level data.
  private DenseMapTypeUInt</*const*/ Value /*P*/ > fMap;
  private /*uint*/int fNext;
  
  /// mdnMap - Map for MDNodes.
  private DenseMapTypeUInt</*const*/ MDNode /*P*/ > mdnMap;
  private /*uint*/int mdnNext;
  
  /// asMap - The slot map for attribute sets.
  private DenseMapTypeUInt<AttributeSet> asMap;
  private /*uint*/int asNext;
/*public:*/
  /// Construct from a module.
  ///
  /// If \c ShouldInitializeAllMetadata, initializes all metadata in all
  /// functions, giving correct numbering for metadata referenced only from
  /// within a function (even if no functions have been initialized).
  
  // Module level constructor. Causes the contents of the Module (sans functions)
  // to be added to the slot table.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::SlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 773,
   FQN="llvm::SlotTracker::SlotTracker", NM="_ZN4llvm11SlotTrackerC1EPKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackerC1EPKNS_6ModuleEb")
  //</editor-fold>
  public SlotTracker(/*const*/ Module /*P*/ M) {
    this(M, false);
  }
  public SlotTracker(/*const*/ Module /*P*/ M, boolean ShouldInitializeAllMetadata/*= false*/) {
    // : TheModule(M), TheFunction(null), FunctionProcessed(false), ShouldInitializeAllMetadata(ShouldInitializeAllMetadata), mMap(), mNext(0), fMap(), fNext(0), mdnMap(), mdnNext(0), asMap(), asNext(0) 
    //START JInit
    this.TheModule = M;
    this.TheFunction = null;
    this.FunctionProcessed = false;
    this.ShouldInitializeAllMetadata = ShouldInitializeAllMetadata;
    this.mMap = new DenseMapTypeUInt</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.mNext = 0;
    this.fMap = new DenseMapTypeUInt</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.fNext = 0;
    this.mdnMap = new DenseMapTypeUInt</*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.mdnNext = 0;
    this.asMap = new DenseMapTypeUInt<AttributeSet>(DenseMapInfoAttributeSet.$Info(), 0);
    this.asNext = 0;
    //END JInit
  }

  /// Construct from a function, starting out in incorp state.
  ///
  /// If \c ShouldInitializeAllMetadata, initializes all metadata in all
  /// functions, giving correct numbering for metadata referenced only from
  /// within a function (even if no functions have been initialized).
  
  // Function level constructor. Causes the contents of the Module and the one
  // function provided to be added to the slot table.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::SlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 780,
   FQN="llvm::SlotTracker::SlotTracker", NM="_ZN4llvm11SlotTrackerC1EPKNS_8FunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackerC1EPKNS_8FunctionEb")
  //</editor-fold>
  public SlotTracker(/*const*/ Function /*P*/ F) {
    this(F, false);
  }
  public SlotTracker(/*const*/ Function /*P*/ F, boolean ShouldInitializeAllMetadata/*= false*/) {
    // : TheModule(F ? F->getParent() : null), TheFunction(F), FunctionProcessed(false), ShouldInitializeAllMetadata(ShouldInitializeAllMetadata), mMap(), mNext(0), fMap(), fNext(0), mdnMap(), mdnNext(0), asMap(), asNext(0) 
    //START JInit
    this.TheModule = (F != null) ? F.getParent$Const() : null;
    this.TheFunction = F;
    this.FunctionProcessed = false;
    this.ShouldInitializeAllMetadata = ShouldInitializeAllMetadata;
    this.mMap = new DenseMapTypeUInt</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.mNext = 0;
    this.fMap = new DenseMapTypeUInt</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.fNext = 0;
    this.mdnMap = new DenseMapTypeUInt</*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.mdnNext = 0;
    this.asMap = new DenseMapTypeUInt<AttributeSet>(DenseMapInfoAttributeSet.$Info(), 0);
    this.asNext = 0;
    //END JInit
  }

  
  /// Return the slot number of the specified value in it's type
  /// plane.  If something is not in the SlotTracker, return -1.
  
  /// getLocalSlot - Get the slot number for a value that is local to a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::getLocalSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 954,
   FQN="llvm::SlotTracker::getLocalSlot", NM="_ZN4llvm11SlotTracker12getLocalSlotEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker12getLocalSlotEPKNS_5ValueE")
  //</editor-fold>
  public int getLocalSlot(/*const*/ Value /*P*/ V) {
    assert (!isa_Constant(V)) : "Can't get a constant or global slot with this!";
    
    // Check for uninitialized state and do lazy initialization.
    initialize();
    
    DenseMapIteratorTypeUInt</*const*/ Value /*P*/ /*P*/> FI = fMap.find(V);
    return FI.$eq(/*NO_ITER_COPY*/fMap.end()) ? -1 : (int)FI.$arrow().second;
  }

  
  /// getGlobalSlot - Get the slot number of a global value.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::getGlobalSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 933,
   FQN="llvm::SlotTracker::getGlobalSlot", NM="_ZN4llvm11SlotTracker13getGlobalSlotEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker13getGlobalSlotEPKNS_11GlobalValueE")
  //</editor-fold>
  public int getGlobalSlot(/*const*/ GlobalValue /*P*/ V) {
    // Check for uninitialized state and do lazy initialization.
    initialize();
    
    // Find the value in the module map
    DenseMapIteratorTypeUInt</*const*/ Value /*P*/ /*P*/> MI = mMap.find(V);
    return MI.$eq(/*NO_ITER_COPY*/mMap.end()) ? -1 : (int)MI.$arrow().second;
  }

  
  /// getMetadataSlot - Get the slot number of a MDNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::getMetadataSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 943,
   FQN="llvm::SlotTracker::getMetadataSlot", NM="_ZN4llvm11SlotTracker15getMetadataSlotEPKNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker15getMetadataSlotEPKNS_6MDNodeE")
  //</editor-fold>
  public int getMetadataSlot(/*const*/ MDNode /*P*/ N) {
    // Check for uninitialized state and do lazy initialization.
    initialize();
    
    // Find the MDNode in the module map
    DenseMapIteratorTypeUInt</*const*/ MDNode /*P*/ /*P*/> MI = mdnMap.find(N);
    return MI.$eq(/*NO_ITER_COPY*/mdnMap.end()) ? -1 : (int)MI.$arrow().second;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::getAttributeGroupSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 964,
   FQN="llvm::SlotTracker::getAttributeGroupSlot", NM="_ZN4llvm11SlotTracker21getAttributeGroupSlotENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker21getAttributeGroupSlotENS_12AttributeSetE")
  //</editor-fold>
  public int getAttributeGroupSlot(AttributeSet AS) {
    // Check for uninitialized state and do lazy initialization.
    initialize();
    
    // Find the AttributeSet in the module map.
    DenseMapIteratorTypeUInt<AttributeSet> AI = asMap.find(AS);
    return AI.$eq(/*NO_ITER_COPY*/asMap.end()) ? -1 : (int)AI.$arrow().second;
  }

  
  /// If you'd like to deal with a function instead of just a module, use
  /// this method to get its data into the SlotTracker.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::incorporateFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 634,
   FQN="llvm::SlotTracker::incorporateFunction", NM="_ZN4llvm11SlotTracker19incorporateFunctionEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker19incorporateFunctionEPKNS_8FunctionE")
  //</editor-fold>
  public void incorporateFunction(/*const*/ Function /*P*/ F) {
    TheFunction = F;
    FunctionProcessed = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 639,
   FQN="llvm::SlotTracker::getFunction", NM="_ZNK4llvm11SlotTracker11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11SlotTracker11getFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*P*/ getFunction() /*const*/ {
    return TheFunction;
  }

  
  /// After calling incorporateFunction, use this method to remove the
  /// most recently incorporated function from the SlotTracker. This
  /// will reset the state of the machine back to just the module contents.
  
  /// Clean up after incorporating a function. This is the only way to get out of
  /// the function incorporation state that affects get*Slot/Create*Slot. Function
  /// incorporation state is indicated by TheFunction != 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::purgeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 924,
   FQN="llvm::SlotTracker::purgeFunction", NM="_ZN4llvm11SlotTracker13purgeFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker13purgeFunctionEv")
  //</editor-fold>
  public void purgeFunction() {
    ;
    fMap.clear(); // Simply discard the function level map
    TheFunction = null;
    FunctionProcessed = false;
    ;
  }

  
  /// MDNode map iterators.
  // JAVA: typedef DenseMap<const MDNode *, unsigned int>::iterator mdn_iterator
//  public final class mdn_iterator extends DenseMapIteratorTypeUInt</*const*/ MDNode /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::mdn_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 648,
   FQN="llvm::SlotTracker::mdn_begin", NM="_ZN4llvm11SlotTracker9mdn_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker9mdn_beginEv")
  //</editor-fold>
  public DenseMapIteratorTypeUInt</*const*/ MDNode /*P*/ /*P*/> mdn_begin() {
    return mdnMap.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::mdn_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 649,
   FQN="llvm::SlotTracker::mdn_end", NM="_ZN4llvm11SlotTracker7mdn_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker7mdn_endEv")
  //</editor-fold>
  public DenseMapIteratorTypeUInt</*const*/ MDNode /*P*/ /*P*/> mdn_end() {
    return mdnMap.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::mdn_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 650,
   FQN="llvm::SlotTracker::mdn_size", NM="_ZNK4llvm11SlotTracker8mdn_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11SlotTracker8mdn_sizeEv")
  //</editor-fold>
  public /*uint*/int mdn_size() /*const*/ {
    return mdnMap.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::mdn_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 651,
   FQN="llvm::SlotTracker::mdn_empty", NM="_ZNK4llvm11SlotTracker9mdn_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11SlotTracker9mdn_emptyEv")
  //</editor-fold>
  public boolean mdn_empty() /*const*/ {
    return mdnMap.empty();
  }

  
  /// AttributeSet map iterators.
  // JAVA: typedef DenseMap<AttributeSet, unsigned int>::iterator as_iterator
//  public final class as_iterator extends DenseMapIteratorTypeUInt<AttributeSet>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::as_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 655,
   FQN="llvm::SlotTracker::as_begin", NM="_ZN4llvm11SlotTracker8as_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker8as_beginEv")
  //</editor-fold>
  public DenseMapIteratorTypeUInt<AttributeSet> as_begin() {
    return asMap.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::as_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 656,
   FQN="llvm::SlotTracker::as_end", NM="_ZN4llvm11SlotTracker6as_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker6as_endEv")
  //</editor-fold>
  public DenseMapIteratorTypeUInt<AttributeSet> as_end() {
    return asMap.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::as_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 657,
   FQN="llvm::SlotTracker::as_size", NM="_ZNK4llvm11SlotTracker7as_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11SlotTracker7as_sizeEv")
  //</editor-fold>
  public /*uint*/int as_size() /*const*/ {
    return asMap.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::as_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 658,
   FQN="llvm::SlotTracker::as_empty", NM="_ZNK4llvm11SlotTracker8as_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11SlotTracker8as_emptyEv")
  //</editor-fold>
  public boolean as_empty() /*const*/ {
    return asMap.empty();
  }

  
  /// This function does the actual initialization.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 786,
   FQN="llvm::SlotTracker::initialize", NM="_ZN4llvm11SlotTracker10initializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker10initializeEv")
  //</editor-fold>
  public /*inline*/ void initialize() {
    if ((TheModule != null)) {
      processModule();
      TheModule = null; ///< Prevent re-processing next time we're called.
    }
    if ((TheFunction != null) && !FunctionProcessed) {
      processFunction();
    }
  }


  // Implementation Details
  /*private:*/
  /// CreateModuleSlot - Insert the specified GlobalValue* into the slot table.
  
  /// CreateModuleSlot - Insert the specified GlobalValue* into the slot table.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::CreateModuleSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 974,
   FQN="llvm::SlotTracker::CreateModuleSlot", NM="_ZN4llvm11SlotTracker16CreateModuleSlotEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker16CreateModuleSlotEPKNS_11GlobalValueE")
  //</editor-fold>
  private void CreateModuleSlot(/*const*/ GlobalValue /*P*/ V) {
    assert ((V != null)) : "Can't insert a null Value into SlotTracker!";
    assert (!V.getType().isVoidTy()) : "Doesn't need a slot!";
    assert (!V.hasName()) : "Doesn't need a slot!";
    
    /*uint*/int DestSlot = mNext++;
    mMap.$set(V, DestSlot);
    ;
    ;
  }

  
  /// CreateMetadataSlot - Insert the specified MDNode* into the slot table.
  
  /// CreateModuleSlot - Insert the specified MDNode* into the slot table.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::CreateMetadataSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1004,
   FQN="llvm::SlotTracker::CreateMetadataSlot", NM="_ZN4llvm11SlotTracker18CreateMetadataSlotEPKNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker18CreateMetadataSlotEPKNS_6MDNodeE")
  //</editor-fold>
  private void CreateMetadataSlot(/*const*/ MDNode /*P*/ N) {
    assert ((N != null)) : "Can't insert a null Value into SlotTracker!";
    
    /*uint*/int DestSlot = mdnNext;
    if (!mdnMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(N, DestSlot)).second) {
      return;
    }
    ++mdnNext;
    
    // Recursively add any MDNodes referenced by operands.
    for (/*uint*/int i = 0, e = N.getNumOperands(); i != e; ++i)  {
      {
        /*const*/ MDNode /*P*/ Op = dyn_cast_or_null_MDNode(N.getOperand(i));
        if ((Op != null)) {
          CreateMetadataSlot(Op);
        }
      }
    }
  }

  
  /// CreateFunctionSlot - Insert the specified Value* into the slot table.
  
  /// CreateSlot - Create a new slot for the specified value if it has no name.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::CreateFunctionSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 992,
   FQN="llvm::SlotTracker::CreateFunctionSlot", NM="_ZN4llvm11SlotTracker18CreateFunctionSlotEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker18CreateFunctionSlotEPKNS_5ValueE")
  //</editor-fold>
  private void CreateFunctionSlot(/*const*/ Value /*P*/ V) {
    assert (!V.getType().isVoidTy() && !V.hasName()) : "Doesn't need a slot!";
    
    /*uint*/int DestSlot = fNext++;
    fMap.$set(V, DestSlot);
    ;
  }

  
  /// \brief Insert the specified AttributeSet into the slot table.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::CreateAttributeSetSlot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1018,
   FQN="llvm::SlotTracker::CreateAttributeSetSlot", NM="_ZN4llvm11SlotTracker22CreateAttributeSetSlotENS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker22CreateAttributeSetSlotENS_12AttributeSetE")
  //</editor-fold>
  private void CreateAttributeSetSlot(AttributeSet AS) {
    assert (AS.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) : "Doesn't need a slot!";
    
    DenseMapIteratorTypeUInt<AttributeSet> I = asMap.find(AS);
    if (I.$noteq(/*NO_ITER_COPY*/asMap.end())) {
      return;
    }
    
    /*uint*/int DestSlot = asNext++;
    asMap.$set(AS, DestSlot);
  }

  
  /// Add all of the module level global variables (and their initializers)
  /// and function declarations, but not the contents of those functions.
  
  // Iterate through all the global variables, functions, and global
  // variable initializers and create slots for them.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::processModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 798,
   FQN="llvm::SlotTracker::processModule", NM="_ZN4llvm11SlotTracker13processModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker13processModuleEv")
  //</editor-fold>
  private void processModule() {
    ;
    
    // Add all of the unnamed global variables to the value table.
    for (final /*const*/ GlobalVariable /*&*/ Var : TheModule.globals$Const()) {
      if (!Var.hasName()) {
        CreateModuleSlot($AddrOf(Var));
      }
      processGlobalObjectMetadata(Var);
    }
    
    for (final /*const*/ GlobalAlias /*&*/ A : TheModule.aliases$Const()) {
      if (!A.hasName()) {
        CreateModuleSlot($AddrOf(A));
      }
    }
    
    for (final /*const*/ GlobalIFunc /*&*/ I : TheModule.ifuncs$Const()) {
      if (!I.hasName()) {
        CreateModuleSlot($AddrOf(I));
      }
    }
    
    // Add metadata used by named metadata.
    for (final /*const*/ NamedMDNode /*&*/ NMD : TheModule.named_metadata$Const()) {
      for (/*uint*/int i = 0, e = NMD.getNumOperands(); i != e; ++i)  {
        CreateMetadataSlot(NMD.getOperand(i));
      }
    }
    
    for (final /*const*/ Function /*&*/ F : $Deref(TheModule)) {
      if (!F.hasName()) {
        // Add all the unnamed functions to the table.
        CreateModuleSlot($AddrOf(F));
      }
      if (ShouldInitializeAllMetadata) {
        processFunctionMetadata(F);
      }
      
      // Add all the function attributes to the table.
      // FIXME: Add attributes of other objects?
      AttributeSet FnAttrs = F.getAttributes().getFnAttributes();
      if (FnAttrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
        CreateAttributeSetSlot(new AttributeSet(FnAttrs));
      }
    }
    ;
  }

  
  /// Add all of the functions arguments, basic blocks, and instructions.
  
  // Process the arguments, basic blocks, and instructions  of a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::processFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 843,
   FQN="llvm::SlotTracker::processFunction", NM="_ZN4llvm11SlotTracker15processFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker15processFunctionEv")
  //</editor-fold>
  private void processFunction() {
    ;
    fNext = 0;
    
    // Process function metadata if it wasn't hit at the module-level.
    if (!ShouldInitializeAllMetadata) {
      processFunctionMetadata($Deref(TheFunction));
    }
    
    // Add all the function arguments with no names.
    for (ilist_iterator</*const*/ Argument> AI = TheFunction.arg_begin$Const(), 
        AE = TheFunction.arg_end$Const(); AI.$noteq(AE); AI.$preInc())  {
      if (!AI.$arrow().hasName()) {
        CreateFunctionSlot($AddrOf(AI.$star()));
      }
    }
    ;
    
    // Add all of the basic blocks and instructions with no names.
    for (final /*const*/ BasicBlock /*&*/ BB : $Deref(TheFunction)) {
      if (!BB.hasName()) {
        CreateFunctionSlot($AddrOf(BB));
      }
      
      for (final /*const*/ Instruction /*&*/ I : BB) {
        if (!I.getType().isVoidTy() && !I.hasName()) {
          CreateFunctionSlot($AddrOf(I));
        }
        {
          
          // We allow direct calls to any llvm.foo function here, because the
          // target may not be linked into the optimizer.
          /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
          if ((CI != null)) {
            // Add all the call attributes to the table.
            AttributeSet Attrs = CI.getAttributes().getFnAttributes();
            if (Attrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
              CreateAttributeSetSlot(new AttributeSet(Attrs));
            }
          } else {
            /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst($AddrOf(I));
            if ((II != null)) {
              // Add all the call attributes to the table.
              AttributeSet Attrs = II.getAttributes().getFnAttributes();
              if (Attrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
                CreateAttributeSetSlot(new AttributeSet(Attrs));
              }
            }
          }
        }
      }
    }
    
    FunctionProcessed = true;
    ;
  }

  
  /// Add the metadata directly attached to a GlobalObject.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::processGlobalObjectMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 889,
   FQN="llvm::SlotTracker::processGlobalObjectMetadata", NM="_ZN4llvm11SlotTracker27processGlobalObjectMetadataERKNS_12GlobalObjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker27processGlobalObjectMetadataERKNS_12GlobalObjectE")
  //</editor-fold>
  private void processGlobalObjectMetadata(final /*const*/ GlobalObject /*&*/ GO) {
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    GO.getAllMetadata(MDs);
    for (final std.pairUIntPtr<MDNode /*P*/ > /*&*/ MD : MDs)  {
      CreateMetadataSlot(MD.second);
    }
  }

  
  /// Add all of the metadata from a function.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::processFunctionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 896,
   FQN="llvm::SlotTracker::processFunctionMetadata", NM="_ZN4llvm11SlotTracker23processFunctionMetadataERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker23processFunctionMetadataERKNS_8FunctionE")
  //</editor-fold>
  private void processFunctionMetadata(final /*const*/ Function /*&*/ F) {
    processGlobalObjectMetadata(F);
    for (final /*const*/ BasicBlock /*&*/ BB : F) {
      for (final /*const*/ Instruction /*&*/ I : BB)  {
        processInstructionMetadata(I);
      }
    }
  }

  
  /// Add all of the metadata from an instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::processInstructionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 904,
   FQN="llvm::SlotTracker::processInstructionMetadata", NM="_ZN4llvm11SlotTracker26processInstructionMetadataERKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTracker26processInstructionMetadataERKNS_11InstructionE")
  //</editor-fold>
  private void processInstructionMetadata(final /*const*/ Instruction /*&*/ I) {
    {
      // Process metadata used directly by intrinsics.
      /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
      if ((CI != null)) {
        {
          Function /*P*/ F = CI.getCalledFunction();
          if ((F != null)) {
            if (F.isIntrinsic()) {
              for (final /*const*/ Use /*&*/ Op : I.operands$Const())  {
                {
                  MetadataAsValue /*P*/ V = dyn_cast_or_null_MetadataAsValue(Op);
                  if ((V != null)) {
                    {
                      MDNode /*P*/ N = dyn_cast_MDNode(V.getMetadata());
                      if ((N != null)) {
                        CreateMetadataSlot(N);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    // Process metadata attached to this instruction.
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    I.getAllMetadata(MDs);
    for (final std.pairUIntPtr<MDNode /*P*/ > /*&*/ MD : MDs)  {
      CreateMetadataSlot(MD.second);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::SlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 693,
   FQN="llvm::SlotTracker::SlotTracker", NM="_ZN4llvm11SlotTrackerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackerC1ERKS0_")
  //</editor-fold>
  protected/*private*/ SlotTracker(final /*const*/ SlotTracker /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 694,
   FQN="llvm::SlotTracker::operator=", NM="_ZN4llvm11SlotTrackeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackeraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ SlotTracker /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::SlotTracker::~SlotTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 580,
   FQN="llvm::SlotTracker::~SlotTracker", NM="_ZN4llvm11SlotTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11SlotTrackerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    asMap.$destroy();
    mdnMap.$destroy();
    fMap.$destroy();
    mMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TheModule=" + TheModule // NOI18N
              + ", TheFunction=" + TheFunction // NOI18N
              + ", FunctionProcessed=" + FunctionProcessed // NOI18N
              + ", ShouldInitializeAllMetadata=" + ShouldInitializeAllMetadata // NOI18N
              + ", mMap=" + mMap // NOI18N
              + ", mNext=" + mNext // NOI18N
              + ", fMap=" + fMap // NOI18N
              + ", fNext=" + fNext // NOI18N
              + ", mdnMap=" + mdnMap // NOI18N
              + ", mdnNext=" + mdnNext // NOI18N
              + ", asMap=" + asMap // NOI18N
              + ", asNext=" + asNext; // NOI18N
  }
}
