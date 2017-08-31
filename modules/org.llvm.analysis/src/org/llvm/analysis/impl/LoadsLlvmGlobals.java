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
package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type LoadsLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.LoadsLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp -nm=_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb;_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE; -static-type=LoadsLlvmGlobals -package=org.llvm.analysis.impl")
//</editor-fold>
public final class LoadsLlvmGlobals {


/// isDereferenceablePointer - Return true if this is always a dereferenceable
/// pointer. If the context instruction is specified perform context-sensitive
/// analysis and return true if the pointer is dereferenceable at the
/// specified instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isDereferenceablePointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp", line = 137,
 FQN="llvm::isDereferenceablePointer", NM="_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp -nm=_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isDereferenceablePointer(V, DL, 
                        (/*const*/ Instruction /*P*/ )null, 
                        (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isDereferenceablePointer(V, DL, 
                        CtxI, 
                        (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                        /*const*/ Instruction /*P*/ CtxI/*= null*/, 
                        /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if V is always a dereferenceable pointer with alignment
/// greater or equal than requested. If the context instruction is specified
/// performs context-sensitive analysis and returns true if the pointer is
/// dereferenceable at the specified instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isDereferenceableAndAlignedPointer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp", line = 113,
 FQN="llvm::isDereferenceableAndAlignedPointer", NM="_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp -nm=_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align, 
                                  final /*const*/ DataLayout /*&*/ DL) {
  return isDereferenceableAndAlignedPointer(V, Align, 
                                  DL, 
                                  (/*const*/ Instruction /*P*/ )null, 
                                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align, 
                                  final /*const*/ DataLayout /*&*/ DL, 
                                  /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isDereferenceableAndAlignedPointer(V, Align, 
                                  DL, 
                                  CtxI, 
                                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align, 
                                  final /*const*/ DataLayout /*&*/ DL, 
                                  /*const*/ Instruction /*P*/ CtxI/*= null*/, 
                                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// isSafeToLoadUnconditionally - Return true if we know that executing a load
/// from this value cannot trap.
///
/// If DT and ScanFrom are specified this method performs context-sensitive
/// analysis and returns true if it is safe to load immediately before ScanFrom.
///
/// If it is not obviously safe to load from the specified pointer, we do a
/// quick local scan of the basic block containing ScanFrom, to determine if
/// the address is already accessed.

/// \brief Check if executing a load of this pointer value cannot trap.
///
/// If DT and ScanFrom are specified this method performs context-sensitive
/// analysis and returns true if it is safe to load immediately before ScanFrom.
///
/// If it is not obviously safe to load from the specified pointer, we do
/// a quick local scan of the basic block containing \c ScanFrom, to determine
/// if the address is already accessed.
///
/// This uses the pointee type to determine how many bytes need to be safe to
/// load from the pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToLoadUnconditionally">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp", line = 185,
 FQN="llvm::isSafeToLoadUnconditionally", NM="_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp -nm=_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align, 
                           final /*const*/ DataLayout /*&*/ DL) {
  return isSafeToLoadUnconditionally(V, Align, 
                           DL, 
                           (Instruction /*P*/ )null, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           Instruction /*P*/ ScanFrom/*= null*/) {
  return isSafeToLoadUnconditionally(V, Align, 
                           DL, 
                           ScanFrom, 
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align, 
                           final /*const*/ DataLayout /*&*/ DL, 
                           Instruction /*P*/ ScanFrom/*= null*/, 
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Scan backwards to see if we have the value of the given load
/// available locally within a small number of instructions.
///
/// You can use this function to scan across multiple blocks: after you call
/// this function, if ScanFrom points at the beginning of the block, it's safe
/// to continue scanning the predecessors.
///
/// Note that performing load CSE requires special care to make sure the
/// metadata is set appropriately.  In particular, aliasing metadata needs
/// to be merged.  (This doesn't matter for store-to-load forwarding because
/// the only relevant load gets deleted.)
///
/// \param Load The load we want to replace.
/// \param ScanBB The basic block to scan. FIXME: This is redundant.
/// \param [in,out] ScanFrom The location to start scanning from. When this
/// function returns, it points at the last instruction scanned.
/// \param MaxInstsToScan The maximum number of instructions to scan. If this
/// is zero, the whole block will be scanned.
/// \param AA Optional pointer to alias analysis, to make the scan more
/// precise.
/// \param [out] AATags The aliasing metadata for the operation which produced
/// the value. FIXME: This is basically useless.
/// \param [out] IsLoadCSE Whether the returned value is a load from the same
/// location in memory, as opposed to the value operand of a store.
///
/// \returns The found value, or nullptr if no value is found.
//<editor-fold defaultstate="collapsed" desc="llvm::FindAvailableLoadedValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp", line = 305,
 FQN="llvm::FindAvailableLoadedValue", NM="_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp -nm=_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb")
//</editor-fold>
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load, BasicBlock /*P*/ ScanBB, 
                        final ilist_iterator<Instruction> /*&*/ ScanFrom) {
  return FindAvailableLoadedValue(Load, ScanBB, 
                        ScanFrom, 
                        0/*DefMaxInstsToScan.$T()*/, 
                        (AAResults /*P*/ )null, (AAMDNodes /*P*/ )null, 
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load, BasicBlock /*P*/ ScanBB, 
                        final ilist_iterator<Instruction> /*&*/ ScanFrom, 
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/) {
  return FindAvailableLoadedValue(Load, ScanBB, 
                        ScanFrom, 
                        MaxInstsToScan, 
                        (AAResults /*P*/ )null, (AAMDNodes /*P*/ )null, 
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load, BasicBlock /*P*/ ScanBB, 
                        final ilist_iterator<Instruction> /*&*/ ScanFrom, 
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/, 
                        AAResults /*P*/ AA/*= null*/) {
  return FindAvailableLoadedValue(Load, ScanBB, 
                        ScanFrom, 
                        MaxInstsToScan, 
                        AA, (AAMDNodes /*P*/ )null, 
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load, BasicBlock /*P*/ ScanBB, 
                        final ilist_iterator<Instruction> /*&*/ ScanFrom, 
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/, 
                        AAResults /*P*/ AA/*= null*/, AAMDNodes /*P*/ AATags/*= null*/) {
  return FindAvailableLoadedValue(Load, ScanBB, 
                        ScanFrom, 
                        MaxInstsToScan, 
                        AA, AATags, 
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load, BasicBlock /*P*/ ScanBB, 
                        final ilist_iterator<Instruction> /*&*/ ScanFrom, 
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/, 
                        AAResults /*P*/ AA/*= null*/, AAMDNodes /*P*/ AATags/*= null*/, 
                        bool$ptr/*bool P*/ IsLoadCSE/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class LoadsLlvmGlobals
