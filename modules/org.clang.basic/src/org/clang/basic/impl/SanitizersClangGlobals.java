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
package org.clang.basic.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type SanitizersClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb;_ZN5clang21expandSanitizerGroupsEy; -static-type=SanitizersClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class SanitizersClangGlobals {


/// Parse a single value from a -fsanitize= or -fno-sanitize= value list.
/// Returns a non-zero SanitizerMask, or \c 0 if \p Value is not known.
//<editor-fold defaultstate="collapsed" desc="clang::parseSanitizerValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp", line = 20,
 FQN="clang::parseSanitizerValue", NM="_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb")
//</editor-fold>
public static long/*uint64_t*/ parseSanitizerValue(StringRef Value, boolean AllowGroups) {
  long/*uint64_t*/ ParsedKind = new StringSwitchULong(/*NO_COPY*/Value).
      
      // AddressSanitizer
      Case(/*KEEP_STR*/"address", SanitizerKind.Address).
      
      // Kernel AddressSanitizer (KASan)
      Case(/*KEEP_STR*/"kernel-address", SanitizerKind.KernelAddress).
      
      // MemorySanitizer
      Case(/*KEEP_STR*/"memory", SanitizerKind.Memory).
      
      // ThreadSanitizer
      Case(/*KEEP_STR*/"thread", SanitizerKind.Thread).
      
      // LeakSanitizer
      Case(/*KEEP_STR*/"leak", SanitizerKind.Leak).
      
      // UndefinedBehaviorSanitizer
      Case(/*KEEP_STR*/"alignment", SanitizerKind.Alignment).
      Case(/*KEEP_STR*/"array-bounds", SanitizerKind.ArrayBounds).
      Case(/*KEEP_STR*/"bool", SanitizerKind.Bool).
      Case(/*KEEP_STR*/"enum", SanitizerKind.Enum).
      Case(/*KEEP_STR*/"float-cast-overflow", SanitizerKind.FloatCastOverflow).
      Case(/*KEEP_STR*/"float-divide-by-zero", SanitizerKind.FloatDivideByZero).
      Case(/*KEEP_STR*/"function", SanitizerKind.Function).
      Case(/*KEEP_STR*/"integer-divide-by-zero", SanitizerKind.IntegerDivideByZero).
      Case(/*KEEP_STR*/"nonnull-attribute", SanitizerKind.NonnullAttribute).
      Case(/*KEEP_STR*/"null", SanitizerKind.Null).
      Case(/*KEEP_STR*/"object-size", SanitizerKind.ObjectSize).
      Case(/*KEEP_STR*/"return", SanitizerKind.Return).
      Case(/*KEEP_STR*/"returns-nonnull-attribute", SanitizerKind.ReturnsNonnullAttribute).
      Case(/*KEEP_STR*/"shift-base", SanitizerKind.ShiftBase).
      Case(/*KEEP_STR*/"shift-exponent", SanitizerKind.ShiftExponent).
      Case(/*KEEP_STR*/"shift", AllowGroups ? SanitizerKind.ShiftGroup : 0).
      Case(/*KEEP_STR*/"signed-integer-overflow", SanitizerKind.SignedIntegerOverflow).
      Case(/*KEEP_STR*/"unreachable", SanitizerKind.Unreachable).
      Case(/*KEEP_STR*/"vla-bound", SanitizerKind.VLABound).
      Case(/*KEEP_STR*/"vptr", SanitizerKind.Vptr).
      
      // IntegerSanitizer
      Case(/*KEEP_STR*/"unsigned-integer-overflow", SanitizerKind.UnsignedIntegerOverflow).
      
      // DataFlowSanitizer
      Case(/*KEEP_STR*/"dataflow", SanitizerKind.DataFlow).
      
      // Control Flow Integrity
      Case(/*KEEP_STR*/"cfi-cast-strict", SanitizerKind.CFICastStrict).
      Case(/*KEEP_STR*/"cfi-derived-cast", SanitizerKind.CFIDerivedCast).
      Case(/*KEEP_STR*/"cfi-icall", SanitizerKind.CFIICall).
      Case(/*KEEP_STR*/"cfi-unrelated-cast", SanitizerKind.CFIUnrelatedCast).
      Case(/*KEEP_STR*/"cfi-nvcall", SanitizerKind.CFINVCall).
      Case(/*KEEP_STR*/"cfi-vcall", SanitizerKind.CFIVCall).
      Case(/*KEEP_STR*/"cfi", AllowGroups ? SanitizerKind.CFIGroup : 0).
      
      // Safe Stack
      Case(/*KEEP_STR*/"safe-stack", SanitizerKind.SafeStack).
      
      // -fsanitize=undefined includes all the sanitizers which have low overhead, no
      // ABI or address space layout implications, and only catch undefined behavior.
      Case(/*KEEP_STR*/"undefined", AllowGroups ? SanitizerKind.UndefinedGroup : 0).
      
      // -fsanitize=undefined-trap is an alias for -fsanitize=undefined.
      Case(/*KEEP_STR*/"undefined-trap", AllowGroups ? SanitizerKind.UndefinedTrapGroup : 0).
      Case(/*KEEP_STR*/"integer", AllowGroups ? SanitizerKind.IntegerGroup : 0).
      Case(/*KEEP_STR*/"local-bounds", SanitizerKind.LocalBounds).
      Case(/*KEEP_STR*/"bounds", AllowGroups ? SanitizerKind.BoundsGroup : 0).
      
      // EfficiencySanitizer
      Case(/*KEEP_STR*/"efficiency-cache-frag", SanitizerKind.EfficiencyCacheFrag).
      Case(/*KEEP_STR*/"efficiency-working-set", SanitizerKind.EfficiencyWorkingSet).
      // Meta-group only used internally.
      Case(/*KEEP_STR*/"efficiency-all", AllowGroups ? SanitizerKind.EfficiencyGroup : 0).
      
      // Magic group, containing all sanitizers. For example, "-fno-sanitize=all"
      // can be used to disable all the sanitizers.
      Case(/*KEEP_STR*/"all", AllowGroups ? SanitizerKind.AllGroup : 0).Default(0);
  return ParsedKind;
}


/// For each sanitizer group bit set in \p Kinds, set the bits for sanitizers
/// this group enables.
//<editor-fold defaultstate="collapsed" desc="clang::expandSanitizerGroups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp", line = 30,
 FQN="clang::expandSanitizerGroups", NM="_ZN5clang21expandSanitizerGroupsEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang21expandSanitizerGroupsEy")
//</editor-fold>
public static long/*uint64_t*/ expandSanitizerGroups(long/*uint64_t*/ Kinds) {
  if (((Kinds & SanitizerKind.ShiftGroup) != 0)) {
    Kinds |= SanitizerKind.Shift;
  }
  if (((Kinds & SanitizerKind.CFIGroup) != 0)) {
    Kinds |= SanitizerKind.CFI;
  }
  
  // -fsanitize=undefined includes all the sanitizers which have low overhead, no
  // ABI or address space layout implications, and only catch undefined behavior.
  if (((Kinds & SanitizerKind.UndefinedGroup) != 0)) {
    Kinds |= SanitizerKind.Undefined;
  }
  
  // -fsanitize=undefined-trap is an alias for -fsanitize=undefined.
  if (((Kinds & SanitizerKind.UndefinedTrapGroup) != 0)) {
    Kinds |= SanitizerKind.UndefinedTrap;
  }
  if (((Kinds & SanitizerKind.IntegerGroup) != 0)) {
    Kinds |= SanitizerKind.Integer;
  }
  if (((Kinds & SanitizerKind.BoundsGroup) != 0)) {
    Kinds |= SanitizerKind.Bounds;
  }
  // Meta-group only used internally.
  if (((Kinds & SanitizerKind.EfficiencyGroup) != 0)) {
    Kinds |= SanitizerKind.Efficiency;
  }
  
  // Magic group, containing all sanitizers. For example, "-fno-sanitize=all"
  // can be used to disable all the sanitizers.
  if (((Kinds & SanitizerKind.AllGroup) != 0)) {
    Kinds |= SanitizerKind.All;
  }
  return Kinds;
}

} // END OF class SanitizersClangGlobals
