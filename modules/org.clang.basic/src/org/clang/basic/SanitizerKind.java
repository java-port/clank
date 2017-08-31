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
package org.clang.basic;

import org.clank.support.*;


//<editor-fold defaultstate="collapsed" desc="static type SanitizerKind">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKind16SanitizerOrdinalE;_ZN5clang13SanitizerKindL10EfficiencyE;_ZN5clang13SanitizerKindL10ObjectSizeE;_ZN5clang13SanitizerKindL10ShiftGroupE;_ZN5clang13SanitizerKindL11ArrayBoundsE;_ZN5clang13SanitizerKindL11BoundsGroupE;_ZN5clang13SanitizerKindL11LocalBoundsE;_ZN5clang13SanitizerKindL11UnreachableE;_ZN5clang13SanitizerKindL12IntegerGroupE;_ZN5clang13SanitizerKindL13CFICastStrictE;_ZN5clang13SanitizerKindL13KernelAddressE;_ZN5clang13SanitizerKindL13ShiftExponentE;_ZN5clang13SanitizerKindL13UndefinedTrapE;_ZN5clang13SanitizerKindL14CFIDerivedCastE;_ZN5clang13SanitizerKindL14UndefinedGroupE;_ZN5clang13SanitizerKindL15EfficiencyGroupE;_ZN5clang13SanitizerKindL16CFIUnrelatedCastE;_ZN5clang13SanitizerKindL16NonnullAttributeE;_ZN5clang13SanitizerKindL17FloatCastOverflowE;_ZN5clang13SanitizerKindL17FloatDivideByZeroE;_ZN5clang13SanitizerKindL18UndefinedTrapGroupE;_ZN5clang13SanitizerKindL19EfficiencyCacheFragE;_ZN5clang13SanitizerKindL19IntegerDivideByZeroE;_ZN5clang13SanitizerKindL20EfficiencyWorkingSetE;_ZN5clang13SanitizerKindL21SignedIntegerOverflowE;_ZN5clang13SanitizerKindL23ReturnsNonnullAttributeE;_ZN5clang13SanitizerKindL23UnsignedIntegerOverflowE;_ZN5clang13SanitizerKindL3AllE;_ZN5clang13SanitizerKindL3CFIE;_ZN5clang13SanitizerKindL4BoolE;_ZN5clang13SanitizerKindL4EnumE;_ZN5clang13SanitizerKindL4LeakE;_ZN5clang13SanitizerKindL4NullE;_ZN5clang13SanitizerKindL4VptrE;_ZN5clang13SanitizerKindL5ShiftE;_ZN5clang13SanitizerKindL6BoundsE;_ZN5clang13SanitizerKindL6MemoryE;_ZN5clang13SanitizerKindL6ReturnE;_ZN5clang13SanitizerKindL6ThreadE;_ZN5clang13SanitizerKindL7AddressE;_ZN5clang13SanitizerKindL7IntegerE;_ZN5clang13SanitizerKindL8AllGroupE;_ZN5clang13SanitizerKindL8CFIGroupE;_ZN5clang13SanitizerKindL8CFIICallE;_ZN5clang13SanitizerKindL8CFIVCallE;_ZN5clang13SanitizerKindL8DataFlowE;_ZN5clang13SanitizerKindL8FunctionE;_ZN5clang13SanitizerKindL8VLABoundE;_ZN5clang13SanitizerKindL9AlignmentE;_ZN5clang13SanitizerKindL9CFINVCallE;_ZN5clang13SanitizerKindL9SafeStackE;_ZN5clang13SanitizerKindL9ShiftBaseE;_ZN5clang13SanitizerKindL9UndefinedE; -static-type=SanitizerKind -package=org.clang.basic")
//</editor-fold>
public final class SanitizerKind {


// Assign ordinals to possible values of -fsanitize= flag, which we will use as
// bit positions.
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::SanitizerOrdinal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.h", line = 30,
 FQN="clang::SanitizerKind::SanitizerOrdinal", NM="_ZN5clang13SanitizerKind16SanitizerOrdinalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKind16SanitizerOrdinalE")
//</editor-fold>
public static final class/*enum*/ SanitizerOrdinal/* : uint64_t*/ {
  
  // AddressSanitizer
  public static final int SO_Address = 0;
  
  // Kernel AddressSanitizer (KASan)
  public static final int SO_KernelAddress = SO_Address + 1;
  
  // MemorySanitizer
  public static final int SO_Memory = SO_KernelAddress + 1;
  
  // ThreadSanitizer
  public static final int SO_Thread = SO_Memory + 1;
  
  // LeakSanitizer
  public static final int SO_Leak = SO_Thread + 1;
  
  // UndefinedBehaviorSanitizer
  public static final int SO_Alignment = SO_Leak + 1;
  public static final int SO_ArrayBounds = SO_Alignment + 1;
  public static final int SO_Bool = SO_ArrayBounds + 1;
  public static final int SO_Enum = SO_Bool + 1;
  public static final int SO_FloatCastOverflow = SO_Enum + 1;
  public static final int SO_FloatDivideByZero = SO_FloatCastOverflow + 1;
  public static final int SO_Function = SO_FloatDivideByZero + 1;
  public static final int SO_IntegerDivideByZero = SO_Function + 1;
  public static final int SO_NonnullAttribute = SO_IntegerDivideByZero + 1;
  public static final int SO_Null = SO_NonnullAttribute + 1;
  public static final int SO_ObjectSize = SO_Null + 1;
  public static final int SO_Return = SO_ObjectSize + 1;
  public static final int SO_ReturnsNonnullAttribute = SO_Return + 1;
  public static final int SO_ShiftBase = SO_ReturnsNonnullAttribute + 1;
  public static final int SO_ShiftExponent = SO_ShiftBase + 1;
  public static final int SO_ShiftGroup = SO_ShiftExponent + 1;
  public static final int SO_SignedIntegerOverflow = SO_ShiftGroup + 1;
  public static final int SO_Unreachable = SO_SignedIntegerOverflow + 1;
  public static final int SO_VLABound = SO_Unreachable + 1;
  public static final int SO_Vptr = SO_VLABound + 1;
  
  // IntegerSanitizer
  public static final int SO_UnsignedIntegerOverflow = SO_Vptr + 1;
  
  // DataFlowSanitizer
  public static final int SO_DataFlow = SO_UnsignedIntegerOverflow + 1;
  
  // Control Flow Integrity
  public static final int SO_CFICastStrict = SO_DataFlow + 1;
  public static final int SO_CFIDerivedCast = SO_CFICastStrict + 1;
  public static final int SO_CFIICall = SO_CFIDerivedCast + 1;
  public static final int SO_CFIUnrelatedCast = SO_CFIICall + 1;
  public static final int SO_CFINVCall = SO_CFIUnrelatedCast + 1;
  public static final int SO_CFIVCall = SO_CFINVCall + 1;
  public static final int SO_CFIGroup = SO_CFIVCall + 1;
  
  // Safe Stack
  public static final int SO_SafeStack = SO_CFIGroup + 1;
  
  // -fsanitize=undefined includes all the sanitizers which have low overhead, no
  // ABI or address space layout implications, and only catch undefined behavior.
  public static final int SO_UndefinedGroup = SO_SafeStack + 1;
  
  // -fsanitize=undefined-trap is an alias for -fsanitize=undefined.
  public static final int SO_UndefinedTrapGroup = SO_UndefinedGroup + 1;
  public static final int SO_IntegerGroup = SO_UndefinedTrapGroup + 1;
  public static final int SO_LocalBounds = SO_IntegerGroup + 1;
  public static final int SO_BoundsGroup = SO_LocalBounds + 1;
  
  // EfficiencySanitizer
  public static final int SO_EfficiencyCacheFrag = SO_BoundsGroup + 1;
  public static final int SO_EfficiencyWorkingSet = SO_EfficiencyCacheFrag + 1;
  // Meta-group only used internally.
  public static final int SO_EfficiencyGroup = SO_EfficiencyWorkingSet + 1;
  
  // Magic group, containing all sanitizers. For example, "-fno-sanitize=all"
  // can be used to disable all the sanitizers.
  public static final int SO_AllGroup = SO_EfficiencyGroup + 1;
  public static final int SO_Count = SO_AllGroup + 1;
}

// AddressSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Address">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 42,
 FQN="clang::SanitizerKind::Address", NM="_ZN5clang13SanitizerKindL7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL7AddressE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Address = 1L/*ULL*/ << SanitizerOrdinal.SO_Address;

// Kernel AddressSanitizer (KASan)
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::KernelAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 45,
 FQN="clang::SanitizerKind::KernelAddress", NM="_ZN5clang13SanitizerKindL13KernelAddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL13KernelAddressE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ KernelAddress = 1L/*ULL*/ << SanitizerOrdinal.SO_KernelAddress;

// MemorySanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Memory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 48,
 FQN="clang::SanitizerKind::Memory", NM="_ZN5clang13SanitizerKindL6MemoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL6MemoryE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Memory = 1L/*ULL*/ << SanitizerOrdinal.SO_Memory;

// ThreadSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Thread">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 51,
 FQN="clang::SanitizerKind::Thread", NM="_ZN5clang13SanitizerKindL6ThreadE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL6ThreadE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Thread = 1L/*ULL*/ << SanitizerOrdinal.SO_Thread;

// LeakSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Leak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 54,
 FQN="clang::SanitizerKind::Leak", NM="_ZN5clang13SanitizerKindL4LeakE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL4LeakE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Leak = 1L/*ULL*/ << SanitizerOrdinal.SO_Leak;

// UndefinedBehaviorSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Alignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 57,
 FQN="clang::SanitizerKind::Alignment", NM="_ZN5clang13SanitizerKindL9AlignmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL9AlignmentE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Alignment = 1L/*ULL*/ << SanitizerOrdinal.SO_Alignment;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ArrayBounds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 58,
 FQN="clang::SanitizerKind::ArrayBounds", NM="_ZN5clang13SanitizerKindL11ArrayBoundsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL11ArrayBoundsE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ArrayBounds = 1L/*ULL*/ << SanitizerOrdinal.SO_ArrayBounds;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Bool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 59,
 FQN="clang::SanitizerKind::Bool", NM="_ZN5clang13SanitizerKindL4BoolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL4BoolE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Bool = 1L/*ULL*/ << SanitizerOrdinal.SO_Bool;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Enum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 60,
 FQN="clang::SanitizerKind::Enum", NM="_ZN5clang13SanitizerKindL4EnumE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL4EnumE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Enum = 1L/*ULL*/ << SanitizerOrdinal.SO_Enum;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::FloatCastOverflow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 61,
 FQN="clang::SanitizerKind::FloatCastOverflow", NM="_ZN5clang13SanitizerKindL17FloatCastOverflowE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL17FloatCastOverflowE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ FloatCastOverflow = 1L/*ULL*/ << SanitizerOrdinal.SO_FloatCastOverflow;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::FloatDivideByZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 62,
 FQN="clang::SanitizerKind::FloatDivideByZero", NM="_ZN5clang13SanitizerKindL17FloatDivideByZeroE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL17FloatDivideByZeroE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ FloatDivideByZero = 1L/*ULL*/ << SanitizerOrdinal.SO_FloatDivideByZero;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Function">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 63,
 FQN="clang::SanitizerKind::Function", NM="_ZN5clang13SanitizerKindL8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8FunctionE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Function = 1L/*ULL*/ << SanitizerOrdinal.SO_Function;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::IntegerDivideByZero">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 64,
 FQN="clang::SanitizerKind::IntegerDivideByZero", NM="_ZN5clang13SanitizerKindL19IntegerDivideByZeroE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL19IntegerDivideByZeroE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ IntegerDivideByZero = 1L/*ULL*/ << SanitizerOrdinal.SO_IntegerDivideByZero;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::NonnullAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 65,
 FQN="clang::SanitizerKind::NonnullAttribute", NM="_ZN5clang13SanitizerKindL16NonnullAttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL16NonnullAttributeE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ NonnullAttribute = 1L/*ULL*/ << SanitizerOrdinal.SO_NonnullAttribute;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Null">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 66,
 FQN="clang::SanitizerKind::Null", NM="_ZN5clang13SanitizerKindL4NullE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL4NullE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Null = 1L/*ULL*/ << SanitizerOrdinal.SO_Null;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ObjectSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 67,
 FQN="clang::SanitizerKind::ObjectSize", NM="_ZN5clang13SanitizerKindL10ObjectSizeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL10ObjectSizeE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ObjectSize = 1L/*ULL*/ << SanitizerOrdinal.SO_ObjectSize;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Return">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 68,
 FQN="clang::SanitizerKind::Return", NM="_ZN5clang13SanitizerKindL6ReturnE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL6ReturnE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Return = 1L/*ULL*/ << SanitizerOrdinal.SO_Return;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ReturnsNonnullAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 69,
 FQN="clang::SanitizerKind::ReturnsNonnullAttribute", NM="_ZN5clang13SanitizerKindL23ReturnsNonnullAttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL23ReturnsNonnullAttributeE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ReturnsNonnullAttribute = 1L/*ULL*/ << SanitizerOrdinal.SO_ReturnsNonnullAttribute;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ShiftBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 70,
 FQN="clang::SanitizerKind::ShiftBase", NM="_ZN5clang13SanitizerKindL9ShiftBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL9ShiftBaseE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ShiftBase = 1L/*ULL*/ << SanitizerOrdinal.SO_ShiftBase;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ShiftExponent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 71,
 FQN="clang::SanitizerKind::ShiftExponent", NM="_ZN5clang13SanitizerKindL13ShiftExponentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL13ShiftExponentE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ShiftExponent = 1L/*ULL*/ << SanitizerOrdinal.SO_ShiftExponent;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Shift">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 72,
 FQN="clang::SanitizerKind::Shift", NM="_ZN5clang13SanitizerKindL5ShiftE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL5ShiftE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Shift = ShiftBase | ShiftExponent;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::ShiftGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 72,
 FQN="clang::SanitizerKind::ShiftGroup", NM="_ZN5clang13SanitizerKindL10ShiftGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL10ShiftGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ ShiftGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_ShiftGroup;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::SignedIntegerOverflow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 73,
 FQN="clang::SanitizerKind::SignedIntegerOverflow", NM="_ZN5clang13SanitizerKindL21SignedIntegerOverflowE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL21SignedIntegerOverflowE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ SignedIntegerOverflow = 1L/*ULL*/ << SanitizerOrdinal.SO_SignedIntegerOverflow;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Unreachable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 74,
 FQN="clang::SanitizerKind::Unreachable", NM="_ZN5clang13SanitizerKindL11UnreachableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL11UnreachableE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Unreachable = 1L/*ULL*/ << SanitizerOrdinal.SO_Unreachable;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::VLABound">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 75,
 FQN="clang::SanitizerKind::VLABound", NM="_ZN5clang13SanitizerKindL8VLABoundE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8VLABoundE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ VLABound = 1L/*ULL*/ << SanitizerOrdinal.SO_VLABound;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Vptr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 76,
 FQN="clang::SanitizerKind::Vptr", NM="_ZN5clang13SanitizerKindL4VptrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL4VptrE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Vptr = 1L/*ULL*/ << SanitizerOrdinal.SO_Vptr;

// IntegerSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::UnsignedIntegerOverflow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 79,
 FQN="clang::SanitizerKind::UnsignedIntegerOverflow", NM="_ZN5clang13SanitizerKindL23UnsignedIntegerOverflowE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL23UnsignedIntegerOverflowE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ UnsignedIntegerOverflow = 1L/*ULL*/ << SanitizerOrdinal.SO_UnsignedIntegerOverflow;

// DataFlowSanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::DataFlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 82,
 FQN="clang::SanitizerKind::DataFlow", NM="_ZN5clang13SanitizerKindL8DataFlowE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8DataFlowE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ DataFlow = 1L/*ULL*/ << SanitizerOrdinal.SO_DataFlow;

// Control Flow Integrity
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFICastStrict">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 85,
 FQN="clang::SanitizerKind::CFICastStrict", NM="_ZN5clang13SanitizerKindL13CFICastStrictE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL13CFICastStrictE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFICastStrict = 1L/*ULL*/ << SanitizerOrdinal.SO_CFICastStrict;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFIDerivedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 86,
 FQN="clang::SanitizerKind::CFIDerivedCast", NM="_ZN5clang13SanitizerKindL14CFIDerivedCastE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL14CFIDerivedCastE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFIDerivedCast = 1L/*ULL*/ << SanitizerOrdinal.SO_CFIDerivedCast;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFIICall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 87,
 FQN="clang::SanitizerKind::CFIICall", NM="_ZN5clang13SanitizerKindL8CFIICallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8CFIICallE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFIICall = 1L/*ULL*/ << SanitizerOrdinal.SO_CFIICall;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFIUnrelatedCast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 88,
 FQN="clang::SanitizerKind::CFIUnrelatedCast", NM="_ZN5clang13SanitizerKindL16CFIUnrelatedCastE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL16CFIUnrelatedCastE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFIUnrelatedCast = 1L/*ULL*/ << SanitizerOrdinal.SO_CFIUnrelatedCast;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFINVCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 89,
 FQN="clang::SanitizerKind::CFINVCall", NM="_ZN5clang13SanitizerKindL9CFINVCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL9CFINVCallE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFINVCall = 1L/*ULL*/ << SanitizerOrdinal.SO_CFINVCall;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFIVCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 90,
 FQN="clang::SanitizerKind::CFIVCall", NM="_ZN5clang13SanitizerKindL8CFIVCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8CFIVCallE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFIVCall = 1L/*ULL*/ << SanitizerOrdinal.SO_CFIVCall;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 91,
 FQN="clang::SanitizerKind::CFI", NM="_ZN5clang13SanitizerKindL3CFIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL3CFIE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFI = CFIDerivedCast | CFIICall | CFIUnrelatedCast | CFINVCall | CFIVCall;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::CFIGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 91,
 FQN="clang::SanitizerKind::CFIGroup", NM="_ZN5clang13SanitizerKindL8CFIGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8CFIGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ CFIGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_CFIGroup;

// Safe Stack
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::SafeStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 96,
 FQN="clang::SanitizerKind::SafeStack", NM="_ZN5clang13SanitizerKindL9SafeStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL9SafeStackE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ SafeStack = 1L/*ULL*/ << SanitizerOrdinal.SO_SafeStack;

// -fsanitize=undefined includes all the sanitizers which have low overhead, no
// ABI or address space layout implications, and only catch undefined behavior.
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Undefined">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 100,
 FQN="clang::SanitizerKind::Undefined", NM="_ZN5clang13SanitizerKindL9UndefinedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL9UndefinedE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Undefined = Alignment | Bool | ArrayBounds | Enum | FloatCastOverflow | FloatDivideByZero | IntegerDivideByZero | NonnullAttribute | Null | ObjectSize | Return | ReturnsNonnullAttribute | Shift | SignedIntegerOverflow | Unreachable | VLABound | Function | Vptr;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::UndefinedGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 100,
 FQN="clang::SanitizerKind::UndefinedGroup", NM="_ZN5clang13SanitizerKindL14UndefinedGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL14UndefinedGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ UndefinedGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_UndefinedGroup;

// -fsanitize=undefined-trap is an alias for -fsanitize=undefined.
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::UndefinedTrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 108,
 FQN="clang::SanitizerKind::UndefinedTrap", NM="_ZN5clang13SanitizerKindL13UndefinedTrapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL13UndefinedTrapE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ UndefinedTrap = Undefined;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::UndefinedTrapGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 108,
 FQN="clang::SanitizerKind::UndefinedTrapGroup", NM="_ZN5clang13SanitizerKindL18UndefinedTrapGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL18UndefinedTrapGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ UndefinedTrapGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_UndefinedTrapGroup;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Integer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 110,
 FQN="clang::SanitizerKind::Integer", NM="_ZN5clang13SanitizerKindL7IntegerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL7IntegerE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Integer = SignedIntegerOverflow | UnsignedIntegerOverflow | Shift | IntegerDivideByZero;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::IntegerGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 110,
 FQN="clang::SanitizerKind::IntegerGroup", NM="_ZN5clang13SanitizerKindL12IntegerGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL12IntegerGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ IntegerGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_IntegerGroup;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::LocalBounds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 114,
 FQN="clang::SanitizerKind::LocalBounds", NM="_ZN5clang13SanitizerKindL11LocalBoundsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL11LocalBoundsE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ LocalBounds = 1L/*ULL*/ << SanitizerOrdinal.SO_LocalBounds;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Bounds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 115,
 FQN="clang::SanitizerKind::Bounds", NM="_ZN5clang13SanitizerKindL6BoundsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL6BoundsE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Bounds = ArrayBounds | LocalBounds;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::BoundsGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 115,
 FQN="clang::SanitizerKind::BoundsGroup", NM="_ZN5clang13SanitizerKindL11BoundsGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL11BoundsGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ BoundsGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_BoundsGroup;

// EfficiencySanitizer
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::EfficiencyCacheFrag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 118,
 FQN="clang::SanitizerKind::EfficiencyCacheFrag", NM="_ZN5clang13SanitizerKindL19EfficiencyCacheFragE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL19EfficiencyCacheFragE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ EfficiencyCacheFrag = 1L/*ULL*/ << SanitizerOrdinal.SO_EfficiencyCacheFrag;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::EfficiencyWorkingSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 119,
 FQN="clang::SanitizerKind::EfficiencyWorkingSet", NM="_ZN5clang13SanitizerKindL20EfficiencyWorkingSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL20EfficiencyWorkingSetE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ EfficiencyWorkingSet = 1L/*ULL*/ << SanitizerOrdinal.SO_EfficiencyWorkingSet;
// Meta-group only used internally.
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::Efficiency">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 121,
 FQN="clang::SanitizerKind::Efficiency", NM="_ZN5clang13SanitizerKindL10EfficiencyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL10EfficiencyE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Efficiency = EfficiencyCacheFrag | EfficiencyWorkingSet;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::EfficiencyGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 121,
 FQN="clang::SanitizerKind::EfficiencyGroup", NM="_ZN5clang13SanitizerKindL15EfficiencyGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL15EfficiencyGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ EfficiencyGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_EfficiencyGroup;

// Magic group, containing all sanitizers. For example, "-fno-sanitize=all"
// can be used to disable all the sanitizers.
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::All">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 126,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", old_line = 119,
 FQN="clang::SanitizerKind::All", NM="_ZN5clang13SanitizerKindL3AllE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL3AllE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ All = ~0L/*ULL*/;
//<editor-fold defaultstate="collapsed" desc="clang::SanitizerKind::AllGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", line = 126,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Sanitizers.def", old_line = 119,
 FQN="clang::SanitizerKind::AllGroup", NM="_ZN5clang13SanitizerKindL8AllGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang13SanitizerKindL8AllGroupE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ AllGroup = 1L/*ULL*/ << SanitizerOrdinal.SO_AllGroup;
} // END OF class SanitizerKind
