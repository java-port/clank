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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.diag.*;
import static org.clang.basic.DiagnosticGroupsGlobals.*;

// JAVA: StaticDiagInfo field was extracted into separate class

//<editor-fold defaultstate="collapsed" desc="static type DiagnosticIDsStatics">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_DiagnosticIDs_cpp_Unnamed_enum;_ZL11GetDiagInfoj;_ZL11OptionTable;_ZL14StaticDiagInfo;_ZL17CategoryNameTable;_ZL18StaticDiagInfoSize;_ZL19getBuiltinDiagClassj;_ZL21GetDefaultDiagMappingj;_ZL21getDiagnosticsInGroupN5clang4diag6FlavorEPKN12_GLOBAL__N_113WarningOptionERN4llvm15SmallVectorImplIjEE;_ZL7toLevelN5clang4diag8SeverityE; -static-type=DiagnosticIDsStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class DiagnosticIDsStatics {


// Diagnostic classes.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 31,
 FQN="(anonymous namespace)::(anonymous)", NM="_DiagnosticIDs_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_DiagnosticIDs_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int CLASS_NOTE = 0x01;
  public static final /*uint*/int CLASS_REMARK = 0x02;
  public static final /*uint*/int CLASS_WARNING = 0x03;
  public static final /*uint*/int CLASS_EXTENSION = 0x04;
  public static final /*uint*/int CLASS_ERROR = 0x05;
/*}*/
// namespace anonymous
//<editor-fold defaultstate="collapsed" desc="StaticDiagInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 73,
 FQN="StaticDiagInfo", NM="_ZL14StaticDiagInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL14StaticDiagInfo")
//</editor-fold>
public static final /*const*/ StaticDiagInfoRec StaticDiagInfo[/*4246*/] = JavaHugeStaticDiagInfoDelegate.StaticDiagInfo; // MANUAL_SEMANTIC: array is huge and was extracted into own class

//<editor-fold defaultstate="collapsed" desc="StaticDiagInfoSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 94,
 FQN="StaticDiagInfoSize", NM="_ZL18StaticDiagInfoSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL18StaticDiagInfoSize")
//</editor-fold>
public static /*const*//*uint*/int StaticDiagInfoSize = llvm.array_lengthof(StaticDiagInfo);

/// GetDiagInfo - Return the StaticDiagInfoRec entry for the specified DiagID,
/// or null if the ID is invalid.
//<editor-fold defaultstate="collapsed" desc="GetDiagInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 98,
 FQN="GetDiagInfo", NM="_ZL11GetDiagInfoj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL11GetDiagInfoj")
//</editor-fold>
public static /*const*/ StaticDiagInfoRec /*P*/ GetDiagInfo(/*uint*/int DiagID) {
  final/*static*/ boolean IsFirst = GetDiagInfo$$.IsFirst; // So the check is only performed on first call.
  if (IsFirst) {
    assert (std.is_sorted(std.begin(StaticDiagInfo), std.end(StaticDiagInfo))) : "Diag ID conflict, the enums at the start of clang::diag (in DiagnosticIDs.h) probably need to be increased";
    GetDiagInfo$$.IsFirst = false;
  }
  
  // Out of bounds diag. Can't be in the table.
  //JAVA: using namespace diag;
  if ($greatereq_uint(DiagID, DIAG_UPPER_LIMIT) || $lesseq_uint(DiagID, DIAG_START_COMMON)) {
    return null;
  }
  
  // Compute the index of the requested diagnostic in the static table.
  // 1. Add the number of diagnostics in each category preceding the
  //    diagnostic and of the category the diagnostic is in. This gives us
  //    the offset of the category in the table.
  // 2. Subtract the number of IDs in each category from our ID. This gives us
  //    the offset of the diagnostic in the category.
  // This is cheaper than a binary search on the table as it doesn't touch
  // memory at all.
  /*uint*/int Offset = 0;
  /*uint*/int ID = DiagID - DIAG_START_COMMON - 1;
  if ($greater_uint(DiagID, DIAG_START_DRIVER)) {
    Offset += NUM_BUILTIN_COMMON_DIAGNOSTICS - DIAG_START_COMMON - 1;
    ID -= DIAG_START_DRIVER - DIAG_START_COMMON;
  }
  if ($greater_uint(DiagID, DIAG_START_FRONTEND)) {
    Offset += NUM_BUILTIN_DRIVER_DIAGNOSTICS - DIAG_START_DRIVER - 1;
    ID -= DIAG_START_FRONTEND - DIAG_START_DRIVER;
  }
  if ($greater_uint(DiagID, DIAG_START_SERIALIZATION)) {
    Offset += NUM_BUILTIN_FRONTEND_DIAGNOSTICS - DIAG_START_FRONTEND - 1;
    ID -= DIAG_START_SERIALIZATION - DIAG_START_FRONTEND;
  }
  if ($greater_uint(DiagID, DIAG_START_LEX)) {
    Offset += NUM_BUILTIN_SERIALIZATION_DIAGNOSTICS - DIAG_START_SERIALIZATION - 1;
    ID -= DIAG_START_LEX - DIAG_START_SERIALIZATION;
  }
  if ($greater_uint(DiagID, DIAG_START_PARSE)) {
    Offset += NUM_BUILTIN_LEX_DIAGNOSTICS - DIAG_START_LEX - 1;
    ID -= DIAG_START_PARSE - DIAG_START_LEX;
  }
  if ($greater_uint(DiagID, DIAG_START_AST)) {
    Offset += NUM_BUILTIN_PARSE_DIAGNOSTICS - DIAG_START_PARSE - 1;
    ID -= DIAG_START_AST - DIAG_START_PARSE;
  }
  if ($greater_uint(DiagID, DIAG_START_COMMENT)) {
    Offset += NUM_BUILTIN_AST_DIAGNOSTICS - DIAG_START_AST - 1;
    ID -= DIAG_START_COMMENT - DIAG_START_AST;
  }
  if ($greater_uint(DiagID, DIAG_START_SEMA)) {
    Offset += NUM_BUILTIN_COMMENT_DIAGNOSTICS - DIAG_START_COMMENT - 1;
    ID -= DIAG_START_SEMA - DIAG_START_COMMENT;
  }
  if ($greater_uint(DiagID, DIAG_START_ANALYSIS)) {
    Offset += NUM_BUILTIN_SEMA_DIAGNOSTICS - DIAG_START_SEMA - 1;
    ID -= DIAG_START_ANALYSIS - DIAG_START_SEMA;
  }
  
  // Avoid out of bounds reads.
  if ($greatereq_uint(ID + Offset, StaticDiagInfoSize)) {
    return null;
  }
  assert ($less_uint(ID, StaticDiagInfoSize) && $less_uint(Offset, StaticDiagInfoSize));
  
  /*const*/ StaticDiagInfoRec /*P*/ Found = $AddrOf(StaticDiagInfo[ID + Offset]);
  // If the diag id doesn't match we found a different diag, abort. This can
  // happen when this function is called with an ID that points into a hole in
  // the diagID space.
  if ($ushort2uint(Found.DiagID) != DiagID) {
    return null;
  }
  return Found;
}
private static final class GetDiagInfo$$ {
  static /*static*/ boolean IsFirst = true;
}

//<editor-fold defaultstate="collapsed" desc="GetDefaultDiagMapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 157,
 FQN="GetDefaultDiagMapping", NM="_ZL21GetDefaultDiagMappingj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL21GetDefaultDiagMappingj")
//</editor-fold>
public static DiagnosticMapping GetDefaultDiagMapping(/*uint*/int DiagID) {
  DiagnosticMapping Info = DiagnosticMapping.Make(diag.Severity.Fatal, /*IsUser=*/ false, /*IsPragma=*/ false);
  {
    
    /*const*/ StaticDiagInfoRec /*P*/ StaticInfo = GetDiagInfo(DiagID);
    if ((StaticInfo != null)) {
      Info.setSeverity(diag.Severity.valueOf(StaticInfo.DefaultSeverity));
      if (StaticInfo.WarnNoWerror) {
        assert (Info.getSeverity() == diag.Severity.Warning) : "Unexpected mapping with no-Werror bit!";
        Info.setNoWarningAsError(true);
      }
    }
  }
  
  return Info;
}

//<editor-fold defaultstate="collapsed" desc="CategoryNameTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 209,
 FQN="CategoryNameTable", NM="_ZL17CategoryNameTable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL17CategoryNameTable")
//</editor-fold>
public static /*const*/ StaticDiagCategoryRec CategoryNameTable[/*32*/] = new /*const*/ StaticDiagCategoryRec [/*32*/] {
  new StaticDiagCategoryRec(/*KEEP_STR*/""/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Lexical or Preprocessor Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Semantic Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Lambda Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Parse Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Semantic Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC and @properties"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Casting Rules"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Parse Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Weak References"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Restrictions"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"OpenMP Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Inline Assembly Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Coroutines Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Backend Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"AST Deserialization Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Modules Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Nullability Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Generics Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"User-Defined Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"VTable ABI Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Value Conversion Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Documentation Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"ARC Retain Cycle"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Related Result Type Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Deprecations"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Format String Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Cocoa API Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"#pragma message Directive"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Instrumentation Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*KEEP_STR*/"Unused Entity Issue"/*, SKIP_ARG*/), 
  new StaticDiagCategoryRec(/*NULL*/null/*, SKIP_ARG*/)
};

/// getBuiltinDiagClass - Return the class field of the diagnostic.
///
//<editor-fold defaultstate="collapsed" desc="getBuiltinDiagClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 242,
 FQN="getBuiltinDiagClass", NM="_ZL19getBuiltinDiagClassj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL19getBuiltinDiagClassj")
//</editor-fold>
public static /*uint*/int getBuiltinDiagClass(/*uint*/int DiagID) {
  {
    /*const*/ StaticDiagInfoRec /*P*/ Info = GetDiagInfo(DiagID);
    if ((Info != null)) {
      return Info.Class;
    }
  }
  return ~0/*U*/;
}

//<editor-fold defaultstate="collapsed" desc="toLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 366,
 FQN="toLevel", NM="_ZL7toLevelN5clang4diag8SeverityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL7toLevelN5clang4diag8SeverityE")
//</editor-fold>
public static DiagnosticIDs.Level toLevel(diag.Severity SV) {
  switch (SV) {
   case Ignored:
    return DiagnosticIDs.Level.Ignored;
   case Remark:
    return DiagnosticIDs.Level.Remark;
   case Warning:
    return DiagnosticIDs.Level.Warning;
   case Error:
    return DiagnosticIDs.Level.Error;
   case Fatal:
    return DiagnosticIDs.Level.Fatal;
  }
  throw new llvm_unreachable("unexpected severity");
}


// Second the table of options, sorted by name for fast binary lookup.
//<editor-fold defaultstate="collapsed" desc="OptionTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 505,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 499,
 FQN="OptionTable", NM="_ZL11OptionTable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL11OptionTable")
//</editor-fold>
public static /*const*/ WarningOption OptionTable[/*643*/] = new /*const*/ WarningOption [/*643*/] {
  new WarningOption(/*  */ 0, /* Empty */ 0, /* DiagSubGroup0 */ 1), 
  new WarningOption(/* #pragma-messages */ 1, /* DiagArray1 */ 1, /* Empty */ 0), 
  new WarningOption(/* #warnings */ 18, /* DiagArray2 */ 3, /* Empty */ 0), 
  new WarningOption(/* CFString-literal */ 28, /* DiagArray3 */ 5, /* Empty */ 0), 
  new WarningOption(/* CL4 */ 45, /* Empty */ 0, /* DiagSubGroup4 */ 3), 
  new WarningOption(/* IndependentClass-attribute */ 49, /* DiagArray5 */ 7, /* Empty */ 0), 
  new WarningOption(/* NSObject-attribute */ 76, /* DiagArray6 */ 10, /* Empty */ 0), 
  new WarningOption(/* abi */ 95, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* absolute-value */ 99, /* DiagArray8 */ 12, /* Empty */ 0), 
  new WarningOption(/* abstract-final-class */ 114, /* DiagArray9 */ 17, /* Empty */ 0), 
  new WarningOption(/* abstract-vbase-init */ 135, /* DiagArray10 */ 19, /* Empty */ 0), 
  new WarningOption(/* address */ 155, /* Empty */ 0, /* DiagSubGroup11 */ 6), 
  new WarningOption(/* address-of-array-temporary */ 163, /* DiagArray12 */ 21, /* Empty */ 0), 
  new WarningOption(/* address-of-temporary */ 190, /* DiagArray13 */ 23, /* Empty */ 0), 
  new WarningOption(/* aggregate-return */ 211, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* all */ 228, /* Empty */ 0, /* DiagSubGroup15 */ 10), 
  new WarningOption(/* ambiguous-ellipsis */ 232, /* DiagArray16 */ 25, /* Empty */ 0), 
  new WarningOption(/* ambiguous-macro */ 251, /* DiagArray17 */ 27, /* Empty */ 0), 
  new WarningOption(/* ambiguous-member-template */ 267, /* DiagArray18 */ 29, /* Empty */ 0), 
  new WarningOption(/* analyzer-incompatible-plugin */ 293, /* DiagArray19 */ 31, /* Empty */ 0), 
  new WarningOption(/* anonymous-pack-parens */ 322, /* DiagArray20 */ 33, /* Empty */ 0), 
  new WarningOption(/* arc */ 344, /* Empty */ 0, /* DiagSubGroup21 */ 15), 
  new WarningOption(/* arc-bridge-casts-disallowed-in-nonarc */ 348, /* DiagArray22 */ 35, /* Empty */ 0), 
  new WarningOption(/* arc-maybe-repeated-use-of-weak */ 386, /* DiagArray23 */ 37, /* Empty */ 0), 
  new WarningOption(/* arc-non-pod-memaccess */ 417, /* DiagArray24 */ 39, /* Empty */ 0), 
  new WarningOption(/* arc-performSelector-leaks */ 439, /* DiagArray25 */ 41, /* Empty */ 0), 
  new WarningOption(/* arc-repeated-use-of-weak */ 465, /* DiagArray26 */ 43, /* DiagSubGroup26 */ 19), 
  new WarningOption(/* arc-retain-cycles */ 490, /* DiagArray27 */ 45, /* Empty */ 0), 
  new WarningOption(/* arc-unsafe-retained-assign */ 508, /* DiagArray28 */ 47, /* Empty */ 0), 
  new WarningOption(/* array-bounds */ 535, /* DiagArray29 */ 51, /* Empty */ 0), 
  new WarningOption(/* array-bounds-pointer-arithmetic */ 548, /* DiagArray30 */ 56, /* Empty */ 0), 
  new WarningOption(/* asm */ 580, /* Empty */ 0, /* DiagSubGroup31 */ 21), 
  new WarningOption(/* asm-operand-widths */ 584, /* DiagArray32 */ 59, /* Empty */ 0), 
  new WarningOption(/* assign-enum */ 603, /* DiagArray33 */ 61, /* Empty */ 0), 
  new WarningOption(/* assume */ 615, /* DiagArray34 */ 63, /* Empty */ 0), 
  new WarningOption(/* at-protocol */ 622, /* DiagArray35 */ 65, /* Empty */ 0), 
  new WarningOption(/* atomic-memory-ordering */ 634, /* DiagArray36 */ 67, /* Empty */ 0), 
  new WarningOption(/* atomic-properties */ 657, /* Empty */ 0, /* DiagSubGroup37 */ 23), 
  new WarningOption(/* atomic-property-with-user-defined-accessor */ 675, /* DiagArray38 */ 69, /* Empty */ 0), 
  new WarningOption(/* attribute-packed-for-bitfield */ 718, /* DiagArray39 */ 71, /* Empty */ 0), 
  new WarningOption(/* attributes */ 748, /* Empty */ 0, /* DiagSubGroup40 */ 26), 
  new WarningOption(/* auto-disable-vptr-sanitizer */ 759, /* DiagArray41 */ 73, /* Empty */ 0), 
  new WarningOption(/* auto-import */ 787, /* DiagArray42 */ 75, /* Empty */ 0), 
  new WarningOption(/* auto-storage-class */ 799, /* DiagArray43 */ 77, /* Empty */ 0), 
  new WarningOption(/* auto-var-id */ 818, /* DiagArray44 */ 79, /* Empty */ 0), 
  new WarningOption(/* availability */ 830, /* DiagArray45 */ 81, /* Empty */ 0), 
  new WarningOption(/* backend-plugin */ 843, /* DiagArray46 */ 89, /* Empty */ 0), 
  new WarningOption(/* backslash-newline-escape */ 858, /* DiagArray47 */ 91, /* Empty */ 0), 
  new WarningOption(/* bad-array-new-length */ 883, /* DiagArray48 */ 93, /* Empty */ 0), 
  new WarningOption(/* bad-function-cast */ 904, /* DiagArray49 */ 96, /* Empty */ 0), 
  new WarningOption(/* bind-to-temporary-copy */ 922, /* DiagArray50 */ 98, /* DiagSubGroup50 */ 29), 
  new WarningOption(/* bitfield-constant-conversion */ 945, /* DiagArray51 */ 101, /* Empty */ 0), 
  new WarningOption(/* bitfield-width */ 974, /* DiagArray52 */ 103, /* Empty */ 0), 
  new WarningOption(/* bitwise-op-parentheses */ 989, /* DiagArray53 */ 106, /* Empty */ 0), 
  new WarningOption(/* bool-conversion */ 1012, /* DiagArray54 */ 108, /* DiagSubGroup54 */ 31), 
  new WarningOption(/* bool-conversions */ 1028, /* Empty */ 0, /* DiagSubGroup55 */ 34), 
  new WarningOption(/* braced-scalar-init */ 1045, /* DiagArray56 */ 110, /* Empty */ 0), 
  new WarningOption(/* bridge-cast */ 1064, /* DiagArray57 */ 112, /* Empty */ 0), 
  new WarningOption(/* builtin-macro-redefined */ 1076, /* DiagArray58 */ 115, /* Empty */ 0), 
  new WarningOption(/* builtin-memcpy-chk-size */ 1100, /* DiagArray59 */ 118, /* Empty */ 0), 
  new WarningOption(/* builtin-requires-header */ 1124, /* DiagArray60 */ 120, /* Empty */ 0), 
  new WarningOption(/* c++-compat */ 1148, /* DiagArray61 */ 122, /* Empty */ 0), 
  new WarningOption(/* c++0x-compat */ 1159, /* Empty */ 0, /* DiagSubGroup62 */ 36), 
  new WarningOption(/* c++0x-extensions */ 1172, /* Empty */ 0, /* DiagSubGroup63 */ 38), 
  new WarningOption(/* c++0x-narrowing */ 1189, /* Empty */ 0, /* DiagSubGroup64 */ 40), 
  new WarningOption(/* c++11-compat */ 1205, /* DiagArray65 */ 124, /* DiagSubGroup65 */ 42), 
  new WarningOption(/* c++11-compat-deprecated-writable-strings */ 1218, /* DiagArray66 */ 135, /* Empty */ 0), 
  new WarningOption(/* c++11-compat-pedantic */ 1259, /* Empty */ 0, /* DiagSubGroup67 */ 48), 
  new WarningOption(/* c++11-compat-reserved-user-defined-literal */ 1281, /* DiagArray68 */ 137, /* Empty */ 0), 
  new WarningOption(/* c++11-extensions */ 1324, /* DiagArray69 */ 139, /* DiagSubGroup69 */ 51), 
  new WarningOption(/* c++11-extra-semi */ 1341, /* DiagArray70 */ 167, /* Empty */ 0), 
  new WarningOption(/* c++11-inline-namespace */ 1358, /* DiagArray71 */ 169, /* Empty */ 0), 
  new WarningOption(/* c++11-long-long */ 1381, /* DiagArray72 */ 171, /* Empty */ 0), 
  new WarningOption(/* c++11-narrowing */ 1397, /* DiagArray73 */ 173, /* Empty */ 0), 
  new WarningOption(/* c++14-binary-literal */ 1413, /* DiagArray74 */ 181, /* Empty */ 0), 
  new WarningOption(/* c++14-compat */ 1434, /* Empty */ 0, /* DiagSubGroup75 */ 55), 
  new WarningOption(/* c++14-compat-pedantic */ 1447, /* Empty */ 0, /* DiagSubGroup76 */ 57), 
  new WarningOption(/* c++14-extensions */ 1469, /* DiagArray77 */ 183, /* DiagSubGroup77 */ 59), 
  new WarningOption(/* c++1y-extensions */ 1486, /* Empty */ 0, /* DiagSubGroup78 */ 61), 
  new WarningOption(/* c++1z-compat */ 1503, /* Empty */ 0, /* DiagSubGroup79 */ 63), 
  new WarningOption(/* c++1z-extensions */ 1516, /* DiagArray80 */ 192, /* Empty */ 0), 
  new WarningOption(/* c++98-c++11-c++14-compat */ 1533, /* DiagArray81 */ 204, /* Empty */ 0), 
  new WarningOption(/* c++98-c++11-c++14-compat-pedantic */ 1558, /* DiagArray82 */ 216, /* DiagSubGroup82 */ 66), 
  new WarningOption(/* c++98-c++11-compat */ 1592, /* DiagArray83 */ 218, /* Empty */ 0), 
  new WarningOption(/* c++98-c++11-compat-pedantic */ 1611, /* DiagArray84 */ 228, /* DiagSubGroup84 */ 68), 
  new WarningOption(/* c++98-compat */ 1639, /* DiagArray85 */ 230, /* DiagSubGroup85 */ 70), 
  new WarningOption(/* c++98-compat-bind-to-temporary-copy */ 1652, /* DiagArray86 */ 291, /* Empty */ 0), 
  new WarningOption(/* c++98-compat-local-type-template-args */ 1688, /* DiagArray87 */ 293, /* Empty */ 0), 
  new WarningOption(/* c++98-compat-pedantic */ 1726, /* DiagArray88 */ 295, /* DiagSubGroup88 */ 75), 
  new WarningOption(/* c++98-compat-unnamed-type-template-args */ 1748, /* DiagArray89 */ 307, /* Empty */ 0), 
  new WarningOption(/* c11-extensions */ 1788, /* DiagArray90 */ 309, /* Empty */ 0), 
  new WarningOption(/* c99-compat */ 1803, /* DiagArray91 */ 316, /* Empty */ 0), 
  new WarningOption(/* c99-extensions */ 1814, /* DiagArray92 */ 320, /* Empty */ 0), 
  new WarningOption(/* cast-align */ 1829, /* DiagArray93 */ 331, /* Empty */ 0), 
  new WarningOption(/* cast-calling-convention */ 1840, /* DiagArray94 */ 333, /* Empty */ 0), 
  new WarningOption(/* cast-of-sel-type */ 1864, /* DiagArray95 */ 335, /* Empty */ 0), 
  new WarningOption(/* cast-qual */ 1881, /* DiagArray96 */ 337, /* Empty */ 0), 
  new WarningOption(/* char-align */ 1891, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* char-subscripts */ 1902, /* DiagArray98 */ 340, /* Empty */ 0), 
  new WarningOption(/* clang-cl-pch */ 1918, /* DiagArray99 */ 343, /* Empty */ 0), 
  new WarningOption(/* class-varargs */ 1931, /* DiagArray100 */ 348, /* DiagSubGroup100 */ 80), 
  new WarningOption(/* comma */ 1945, /* DiagArray101 */ 350, /* Empty */ 0), 
  new WarningOption(/* comment */ 1951, /* DiagArray102 */ 352, /* Empty */ 0), 
  new WarningOption(/* comments */ 1959, /* Empty */ 0, /* DiagSubGroup103 */ 82), 
  new WarningOption(/* compare-distinct-pointer-types */ 1968, /* DiagArray104 */ 357, /* Empty */ 0), 
  new WarningOption(/* complex-component-init */ 1999, /* DiagArray105 */ 360, /* Empty */ 0), 
  new WarningOption(/* conditional-type-mismatch */ 2022, /* DiagArray106 */ 362, /* Empty */ 0), 
  new WarningOption(/* conditional-uninitialized */ 2048, /* DiagArray107 */ 364, /* Empty */ 0), 
  new WarningOption(/* config-macros */ 2074, /* DiagArray108 */ 366, /* Empty */ 0), 
  new WarningOption(/* constant-conversion */ 2088, /* DiagArray109 */ 368, /* DiagSubGroup109 */ 84), 
  new WarningOption(/* constant-logical-operand */ 2108, /* DiagArray110 */ 370, /* Empty */ 0), 
  new WarningOption(/* constexpr-not-const */ 2133, /* DiagArray111 */ 372, /* Empty */ 0), 
  new WarningOption(/* consumed */ 2153, /* DiagArray112 */ 374, /* Empty */ 0), 
  new WarningOption(/* conversion */ 2162, /* DiagArray113 */ 383, /* DiagSubGroup113 */ 86), 
  new WarningOption(/* conversion-null */ 2173, /* Empty */ 0, /* DiagSubGroup114 */ 99), 
  new WarningOption(/* coreturn-without-coawait */ 2189, /* DiagArray115 */ 390, /* Empty */ 0), 
  new WarningOption(/* covered-switch-default */ 2214, /* DiagArray116 */ 392, /* Empty */ 0), 
  new WarningOption(/* cstring-format-directive */ 2237, /* DiagArray117 */ 394, /* Empty */ 0), 
  new WarningOption(/* ctor-dtor-privacy */ 2262, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* cuda-compat */ 2280, /* DiagArray119 */ 396, /* Empty */ 0), 
  new WarningOption(/* custom-atomic-properties */ 2292, /* DiagArray120 */ 401, /* Empty */ 0), 
  new WarningOption(/* dangling-else */ 2317, /* DiagArray121 */ 403, /* Empty */ 0), 
  new WarningOption(/* dangling-field */ 2331, /* DiagArray122 */ 405, /* Empty */ 0), 
  new WarningOption(/* dangling-initializer-list */ 2346, /* DiagArray123 */ 409, /* Empty */ 0), 
  new WarningOption(/* date-time */ 2372, /* DiagArray124 */ 411, /* Empty */ 0), 
  new WarningOption(/* dealloc-in-category */ 2382, /* DiagArray125 */ 413, /* Empty */ 0), 
  new WarningOption(/* debug-compression-unavailable */ 2402, /* DiagArray126 */ 415, /* Empty */ 0), 
  new WarningOption(/* declaration-after-statement */ 2432, /* DiagArray127 */ 417, /* Empty */ 0), 
  new WarningOption(/* delegating-ctor-cycles */ 2460, /* DiagArray128 */ 419, /* Empty */ 0), 
  new WarningOption(/* delete-incomplete */ 2483, /* DiagArray129 */ 421, /* Empty */ 0), 
  new WarningOption(/* delete-non-virtual-dtor */ 2501, /* DiagArray130 */ 424, /* Empty */ 0), 
  new WarningOption(/* deprecated */ 2525, /* DiagArray131 */ 427, /* DiagSubGroup131 */ 101), 
  new WarningOption(/* deprecated-attributes */ 2536, /* DiagArray132 */ 437, /* Empty */ 0), 
  new WarningOption(/* deprecated-declarations */ 2558, /* DiagArray133 */ 439, /* Empty */ 0), 
  new WarningOption(/* deprecated-implementations */ 2582, /* DiagArray134 */ 445, /* Empty */ 0), 
  new WarningOption(/* deprecated-increment-bool */ 2609, /* DiagArray135 */ 447, /* Empty */ 0), 
  new WarningOption(/* deprecated-objc-isa-usage */ 2635, /* DiagArray136 */ 449, /* Empty */ 0), 
  new WarningOption(/* deprecated-objc-pointer-introspection */ 2661, /* DiagArray137 */ 452, /* DiagSubGroup137 */ 107), 
  new WarningOption(/* deprecated-objc-pointer-introspection-performSelector */ 2699, /* DiagArray138 */ 454, /* Empty */ 0), 
  new WarningOption(/* deprecated-register */ 2753, /* DiagArray139 */ 456, /* Empty */ 0), 
  new WarningOption(/* deprecated-writable-strings */ 2773, /* Empty */ 0, /* DiagSubGroup140 */ 109), 
  new WarningOption(/* direct-ivar-access */ 2801, /* DiagArray141 */ 458, /* Empty */ 0), 
  new WarningOption(/* disabled-macro-expansion */ 2820, /* DiagArray142 */ 460, /* Empty */ 0), 
  new WarningOption(/* disabled-optimization */ 2845, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* discard-qual */ 2867, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* distributed-object-modifiers */ 2880, /* DiagArray145 */ 462, /* Empty */ 0), 
  new WarningOption(/* div-by-zero */ 2909, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* division-by-zero */ 2921, /* DiagArray147 */ 465, /* Empty */ 0), 
  new WarningOption(/* dll-attribute-on-redeclaration */ 2938, /* DiagArray148 */ 467, /* Empty */ 0), 
  new WarningOption(/* dllexport-explicit-instantiation-decl */ 2969, /* DiagArray149 */ 469, /* Empty */ 0), 
  new WarningOption(/* dllimport-static-field-def */ 3007, /* DiagArray150 */ 471, /* Empty */ 0), 
  new WarningOption(/* documentation */ 3034, /* DiagArray151 */ 473, /* DiagSubGroup151 */ 111), 
  new WarningOption(/* documentation-deprecated-sync */ 3048, /* DiagArray152 */ 492, /* Empty */ 0), 
  new WarningOption(/* documentation-html */ 3078, /* DiagArray153 */ 494, /* Empty */ 0), 
  new WarningOption(/* documentation-pedantic */ 3097, /* DiagArray154 */ 499, /* DiagSubGroup154 */ 114), 
  new WarningOption(/* documentation-unknown-command */ 3120, /* DiagArray155 */ 501, /* Empty */ 0), 
  new WarningOption(/* dollar-in-identifier-extension */ 3150, /* DiagArray156 */ 504, /* Empty */ 0), 
  new WarningOption(/* double-promotion */ 3181, /* DiagArray157 */ 506, /* Empty */ 0), 
  new WarningOption(/* duplicate-decl-specifier */ 3198, /* DiagArray158 */ 508, /* Empty */ 0), 
  new WarningOption(/* duplicate-enum */ 3223, /* DiagArray159 */ 511, /* Empty */ 0), 
  new WarningOption(/* duplicate-method-arg */ 3238, /* DiagArray160 */ 513, /* Empty */ 0), 
  new WarningOption(/* duplicate-method-match */ 3259, /* DiagArray161 */ 515, /* Empty */ 0), 
  new WarningOption(/* dynamic-class-memaccess */ 3282, /* DiagArray162 */ 517, /* Empty */ 0), 
  new WarningOption(/* effc++ */ 3306, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* embedded-directive */ 3313, /* DiagArray164 */ 519, /* Empty */ 0), 
  new WarningOption(/* empty-body */ 3332, /* DiagArray165 */ 521, /* Empty */ 0), 
  new WarningOption(/* empty-translation-unit */ 3343, /* DiagArray166 */ 527, /* Empty */ 0), 
  new WarningOption(/* encode-type */ 3366, /* DiagArray167 */ 529, /* Empty */ 0), 
  new WarningOption(/* endif-labels */ 3378, /* Empty */ 0, /* DiagSubGroup168 */ 116), 
  new WarningOption(/* enum-compare */ 3391, /* DiagArray169 */ 531, /* Empty */ 0), 
  new WarningOption(/* enum-conversion */ 3404, /* DiagArray170 */ 533, /* Empty */ 0), 
  new WarningOption(/* enum-too-large */ 3420, /* DiagArray171 */ 535, /* Empty */ 0), 
  new WarningOption(/* exceptions */ 3435, /* DiagArray172 */ 538, /* Empty */ 0), 
  new WarningOption(/* exit-time-destructors */ 3446, /* DiagArray173 */ 541, /* Empty */ 0), 
  new WarningOption(/* expansion-to-defined */ 3468, /* DiagArray174 */ 543, /* Empty */ 0), 
  new WarningOption(/* explicit-initialize-call */ 3489, /* DiagArray175 */ 546, /* Empty */ 0), 
  new WarningOption(/* explicit-ownership-type */ 3514, /* DiagArray176 */ 549, /* Empty */ 0), 
  new WarningOption(/* extended-offsetof */ 3538, /* DiagArray177 */ 551, /* Empty */ 0), 
  new WarningOption(/* extern-c-compat */ 3556, /* DiagArray178 */ 553, /* Empty */ 0), 
  new WarningOption(/* extern-initializer */ 3572, /* DiagArray179 */ 555, /* Empty */ 0), 
  new WarningOption(/* extra */ 3591, /* Empty */ 0, /* DiagSubGroup180 */ 118), 
  new WarningOption(/* extra-qualification */ 3597, /* DiagArray181 */ 557, /* Empty */ 0), 
  new WarningOption(/* extra-semi */ 3617, /* DiagArray182 */ 559, /* DiagSubGroup182 */ 126), 
  new WarningOption(/* extra-tokens */ 3628, /* DiagArray183 */ 562, /* Empty */ 0), 
  new WarningOption(/* fallback */ 3641, /* DiagArray184 */ 565, /* Empty */ 0), 
  new WarningOption(/* flag-enum */ 3650, /* DiagArray185 */ 567, /* Empty */ 0), 
  new WarningOption(/* flexible-array-extensions */ 3660, /* DiagArray186 */ 569, /* Empty */ 0), 
  new WarningOption(/* float-conversion */ 3686, /* DiagArray187 */ 572, /* DiagSubGroup187 */ 128), 
  new WarningOption(/* float-equal */ 3703, /* DiagArray188 */ 574, /* Empty */ 0), 
  new WarningOption(/* float-overflow-conversion */ 3715, /* DiagArray189 */ 576, /* Empty */ 0), 
  new WarningOption(/* float-zero-conversion */ 3741, /* DiagArray190 */ 578, /* Empty */ 0), 
  new WarningOption(/* for-loop-analysis */ 3763, /* DiagArray191 */ 580, /* Empty */ 0), 
  new WarningOption(/* format */ 3781, /* DiagArray192 */ 583, /* DiagSubGroup192 */ 131), 
  new WarningOption(/* format-extra-args */ 3788, /* DiagArray193 */ 607, /* Empty */ 0), 
  new WarningOption(/* format-invalid-specifier */ 3806, /* DiagArray194 */ 609, /* Empty */ 0), 
  new WarningOption(/* format-non-iso */ 3831, /* DiagArray195 */ 611, /* Empty */ 0), 
  new WarningOption(/* format-nonliteral */ 3846, /* DiagArray196 */ 615, /* Empty */ 0), 
  new WarningOption(/* format-pedantic */ 3864, /* DiagArray197 */ 617, /* Empty */ 0), 
  new WarningOption(/* format-security */ 3880, /* DiagArray198 */ 619, /* Empty */ 0), 
  new WarningOption(/* format-y2k */ 3896, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* format-zero-length */ 3907, /* DiagArray200 */ 621, /* Empty */ 0), 
  new WarningOption(/* format=2 */ 3926, /* Empty */ 0, /* DiagSubGroup201 */ 138), 
  new WarningOption(/* four-char-constants */ 3935, /* DiagArray202 */ 623, /* Empty */ 0), 
  new WarningOption(/* frame-larger-than= */ 3955, /* DiagArray203 */ 625, /* Empty */ 0), 
  new WarningOption(/* function-def-in-objc-container */ 3974, /* DiagArray204 */ 628, /* Empty */ 0), 
  new WarningOption(/* future-compat */ 4005, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* gcc-compat */ 4019, /* DiagArray206 */ 630, /* Empty */ 0), 
  new WarningOption(/* global-constructors */ 4030, /* DiagArray207 */ 637, /* Empty */ 0), 
  new WarningOption(/* gnu */ 4050, /* Empty */ 0, /* DiagSubGroup208 */ 142), 
  new WarningOption(/* gnu-alignof-expression */ 4054, /* DiagArray209 */ 640, /* Empty */ 0), 
  new WarningOption(/* gnu-anonymous-struct */ 4077, /* DiagArray210 */ 642, /* Empty */ 0), 
  new WarningOption(/* gnu-array-member-paren-init */ 4098, /* DiagArray211 */ 644, /* Empty */ 0), 
  new WarningOption(/* gnu-auto-type */ 4126, /* DiagArray212 */ 646, /* Empty */ 0), 
  new WarningOption(/* gnu-binary-literal */ 4140, /* DiagArray213 */ 648, /* Empty */ 0), 
  new WarningOption(/* gnu-case-range */ 4159, /* DiagArray214 */ 650, /* Empty */ 0), 
  new WarningOption(/* gnu-complex-integer */ 4174, /* DiagArray215 */ 652, /* Empty */ 0), 
  new WarningOption(/* gnu-compound-literal-initializer */ 4194, /* DiagArray216 */ 654, /* Empty */ 0), 
  new WarningOption(/* gnu-conditional-omitted-operand */ 4227, /* DiagArray217 */ 656, /* Empty */ 0), 
  new WarningOption(/* gnu-designator */ 4259, /* DiagArray218 */ 658, /* Empty */ 0), 
  new WarningOption(/* gnu-empty-initializer */ 4274, /* DiagArray219 */ 662, /* Empty */ 0), 
  new WarningOption(/* gnu-empty-struct */ 4296, /* DiagArray220 */ 664, /* Empty */ 0), 
  new WarningOption(/* gnu-flexible-array-initializer */ 4313, /* DiagArray221 */ 668, /* Empty */ 0), 
  new WarningOption(/* gnu-flexible-array-union-member */ 4344, /* DiagArray222 */ 670, /* Empty */ 0), 
  new WarningOption(/* gnu-folding-constant */ 4376, /* DiagArray223 */ 672, /* Empty */ 0), 
  new WarningOption(/* gnu-imaginary-constant */ 4397, /* DiagArray224 */ 676, /* Empty */ 0), 
  new WarningOption(/* gnu-include-next */ 4420, /* DiagArray225 */ 678, /* Empty */ 0), 
  new WarningOption(/* gnu-label-as-value */ 4437, /* DiagArray226 */ 680, /* Empty */ 0), 
  new WarningOption(/* gnu-redeclared-enum */ 4456, /* DiagArray227 */ 683, /* Empty */ 0), 
  new WarningOption(/* gnu-statement-expression */ 4476, /* DiagArray228 */ 685, /* Empty */ 0), 
  new WarningOption(/* gnu-static-float-init */ 4501, /* DiagArray229 */ 687, /* Empty */ 0), 
  new WarningOption(/* gnu-string-literal-operator-template */ 4523, /* DiagArray230 */ 689, /* Empty */ 0), 
  new WarningOption(/* gnu-union-cast */ 4560, /* DiagArray231 */ 691, /* Empty */ 0), 
  new WarningOption(/* gnu-variable-sized-type-not-at-end */ 4575, /* DiagArray232 */ 693, /* Empty */ 0), 
  new WarningOption(/* gnu-zero-line-directive */ 4610, /* DiagArray233 */ 695, /* Empty */ 0), 
  new WarningOption(/* gnu-zero-variadic-macro-arguments */ 4634, /* DiagArray234 */ 697, /* Empty */ 0), 
  new WarningOption(/* header-guard */ 4668, /* DiagArray235 */ 700, /* Empty */ 0), 
  new WarningOption(/* header-hygiene */ 4681, /* DiagArray236 */ 702, /* Empty */ 0), 
  new WarningOption(/* idiomatic-parentheses */ 4696, /* DiagArray237 */ 704, /* Empty */ 0), 
  new WarningOption(/* ignored-attributes */ 4718, /* DiagArray238 */ 706, /* Empty */ 0), 
  new WarningOption(/* ignored-optimization-argument */ 4737, /* DiagArray239 */ 759, /* Empty */ 0), 
  new WarningOption(/* ignored-pragmas */ 4767, /* DiagArray240 */ 761, /* Empty */ 0), 
  new WarningOption(/* ignored-qualifiers */ 4783, /* DiagArray241 */ 798, /* Empty */ 0), 
  new WarningOption(/* implicit */ 4802, /* Empty */ 0, /* DiagSubGroup242 */ 171), 
  new WarningOption(/* implicit-atomic-properties */ 4811, /* DiagArray243 */ 804, /* Empty */ 0), 
  new WarningOption(/* implicit-conversion-floating-point-to-bool */ 4838, /* DiagArray244 */ 807, /* Empty */ 0), 
  new WarningOption(/* implicit-exception-spec-mismatch */ 4881, /* DiagArray245 */ 809, /* Empty */ 0), 
  new WarningOption(/* implicit-fallthrough */ 4914, /* DiagArray246 */ 811, /* DiagSubGroup246 */ 174), 
  new WarningOption(/* implicit-fallthrough-per-function */ 4935, /* DiagArray247 */ 814, /* Empty */ 0), 
  new WarningOption(/* implicit-function-declaration */ 4969, /* DiagArray248 */ 816, /* Empty */ 0), 
  new WarningOption(/* implicit-int */ 4999, /* DiagArray249 */ 821, /* Empty */ 0), 
  new WarningOption(/* implicit-retain-self */ 5012, /* DiagArray250 */ 823, /* Empty */ 0), 
  new WarningOption(/* implicitly-unsigned-literal */ 5033, /* DiagArray251 */ 825, /* Empty */ 0), 
  new WarningOption(/* import */ 5061, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* import-preprocessor-directive-pedantic */ 5068, /* DiagArray253 */ 827, /* Empty */ 0), 
  new WarningOption(/* inaccessible-base */ 5107, /* DiagArray254 */ 829, /* Empty */ 0), 
  new WarningOption(/* include-next-absolute-path */ 5125, /* DiagArray255 */ 831, /* Empty */ 0), 
  new WarningOption(/* include-next-outside-header */ 5152, /* DiagArray256 */ 833, /* Empty */ 0), 
  new WarningOption(/* incompatible-library-redeclaration */ 5180, /* DiagArray257 */ 835, /* Empty */ 0), 
  new WarningOption(/* incompatible-ms-struct */ 5215, /* DiagArray258 */ 837, /* Empty */ 0), 
  new WarningOption(/* incompatible-pointer-types */ 5238, /* DiagArray259 */ 839, /* DiagSubGroup259 */ 176), 
  new WarningOption(/* incompatible-pointer-types-discards-qualifiers */ 5265, /* DiagArray260 */ 841, /* Empty */ 0), 
  new WarningOption(/* incompatible-property-type */ 5312, /* DiagArray261 */ 844, /* Empty */ 0), 
  new WarningOption(/* incompatible-sysroot */ 5339, /* DiagArray262 */ 846, /* Empty */ 0), 
  new WarningOption(/* incomplete-implementation */ 5360, /* DiagArray263 */ 848, /* Empty */ 0), 
  new WarningOption(/* incomplete-module */ 5386, /* Empty */ 0, /* DiagSubGroup264 */ 178), 
  new WarningOption(/* incomplete-umbrella */ 5404, /* DiagArray265 */ 850, /* Empty */ 0), 
  new WarningOption(/* inconsistent-dllimport */ 5424, /* DiagArray266 */ 853, /* Empty */ 0), 
  new WarningOption(/* inconsistent-missing-override */ 5447, /* DiagArray267 */ 856, /* Empty */ 0), 
  new WarningOption(/* increment-bool */ 5477, /* DiagArray268 */ 858, /* DiagSubGroup268 */ 181), 
  new WarningOption(/* infinite-recursion */ 5492, /* DiagArray269 */ 860, /* Empty */ 0), 
  new WarningOption(/* init-self */ 5511, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* initializer-overrides */ 5521, /* DiagArray271 */ 862, /* Empty */ 0), 
  new WarningOption(/* inline */ 5543, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* inline-asm */ 5550, /* DiagArray273 */ 865, /* Empty */ 0), 
  new WarningOption(/* inline-new-delete */ 5561, /* DiagArray274 */ 867, /* Empty */ 0), 
  new WarningOption(/* int-conversion */ 5579, /* DiagArray275 */ 869, /* Empty */ 0), 
  new WarningOption(/* int-conversions */ 5594, /* Empty */ 0, /* DiagSubGroup276 */ 183), 
  new WarningOption(/* int-to-pointer-cast */ 5610, /* DiagArray277 */ 872, /* DiagSubGroup277 */ 185), 
  new WarningOption(/* int-to-void-pointer-cast */ 5630, /* DiagArray278 */ 874, /* Empty */ 0), 
  new WarningOption(/* integer-overflow */ 5655, /* DiagArray279 */ 876, /* Empty */ 0), 
  new WarningOption(/* invalid-command-line-argument */ 5672, /* DiagArray280 */ 878, /* DiagSubGroup280 */ 187), 
  new WarningOption(/* invalid-constexpr */ 5702, /* DiagArray281 */ 880, /* Empty */ 0), 
  new WarningOption(/* invalid-iboutlet */ 5720, /* DiagArray282 */ 882, /* Empty */ 0), 
  new WarningOption(/* invalid-initializer-from-system-header */ 5737, /* DiagArray283 */ 885, /* Empty */ 0), 
  new WarningOption(/* invalid-noreturn */ 5776, /* DiagArray284 */ 887, /* Empty */ 0), 
  new WarningOption(/* invalid-offsetof */ 5793, /* DiagArray285 */ 890, /* Empty */ 0), 
  new WarningOption(/* invalid-or-nonexistent-directory */ 5810, /* DiagArray286 */ 893, /* Empty */ 0), 
  new WarningOption(/* invalid-pch */ 5843, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* invalid-pp-token */ 5855, /* DiagArray288 */ 896, /* Empty */ 0), 
  new WarningOption(/* invalid-source-encoding */ 5872, /* DiagArray289 */ 899, /* Empty */ 0), 
  new WarningOption(/* invalid-token-paste */ 5896, /* DiagArray290 */ 902, /* Empty */ 0), 
  new WarningOption(/* jump-seh-finally */ 5916, /* DiagArray291 */ 904, /* Empty */ 0), 
  new WarningOption(/* keyword-compat */ 5933, /* DiagArray292 */ 906, /* Empty */ 0), 
  new WarningOption(/* keyword-macro */ 5948, /* DiagArray293 */ 908, /* Empty */ 0), 
  new WarningOption(/* knr-promoted-parameter */ 5962, /* DiagArray294 */ 910, /* Empty */ 0), 
  new WarningOption(/* language-extension-token */ 5985, /* DiagArray295 */ 912, /* Empty */ 0), 
  new WarningOption(/* large-by-value-copy */ 6010, /* DiagArray296 */ 914, /* Empty */ 0), 
  new WarningOption(/* liblto */ 6030, /* DiagArray297 */ 917, /* Empty */ 0), 
  new WarningOption(/* literal-conversion */ 6037, /* DiagArray298 */ 919, /* Empty */ 0), 
  new WarningOption(/* literal-range */ 6056, /* DiagArray299 */ 921, /* Empty */ 0), 
  new WarningOption(/* local-type-template-args */ 6070, /* DiagArray300 */ 924, /* DiagSubGroup300 */ 189), 
  new WarningOption(/* logical-not-parentheses */ 6095, /* DiagArray301 */ 926, /* Empty */ 0), 
  new WarningOption(/* logical-op-parentheses */ 6119, /* DiagArray302 */ 928, /* Empty */ 0), 
  new WarningOption(/* long-long */ 6142, /* DiagArray303 */ 930, /* DiagSubGroup303 */ 191), 
  new WarningOption(/* loop-analysis */ 6152, /* Empty */ 0, /* DiagSubGroup304 */ 193), 
  new WarningOption(/* macro-redefined */ 6166, /* DiagArray305 */ 932, /* Empty */ 0), 
  new WarningOption(/* main */ 6182, /* DiagArray306 */ 934, /* Empty */ 0), 
  new WarningOption(/* main-return-type */ 6187, /* DiagArray307 */ 941, /* Empty */ 0), 
  new WarningOption(/* malformed-warning-check */ 6204, /* DiagArray308 */ 943, /* Empty */ 0), 
  new WarningOption(/* many-braces-around-scalar-init */ 6228, /* DiagArray309 */ 945, /* Empty */ 0), 
  new WarningOption(/* memsize-comparison */ 6259, /* DiagArray310 */ 947, /* Empty */ 0), 
  new WarningOption(/* method-signatures */ 6278, /* DiagArray311 */ 949, /* Empty */ 0), 
  new WarningOption(/* microsoft */ 6296, /* Empty */ 0, /* DiagSubGroup312 */ 196), 
  new WarningOption(/* microsoft-anon-tag */ 6306, /* DiagArray313 */ 952, /* Empty */ 0), 
  new WarningOption(/* microsoft-cast */ 6325, /* DiagArray314 */ 955, /* Empty */ 0), 
  new WarningOption(/* microsoft-charize */ 6340, /* DiagArray315 */ 958, /* Empty */ 0), 
  new WarningOption(/* microsoft-comment-paste */ 6358, /* DiagArray316 */ 960, /* Empty */ 0), 
  new WarningOption(/* microsoft-const-init */ 6382, /* DiagArray317 */ 962, /* Empty */ 0), 
  new WarningOption(/* microsoft-cpp-macro */ 6403, /* DiagArray318 */ 964, /* Empty */ 0), 
  new WarningOption(/* microsoft-default-arg-redefinition */ 6423, /* DiagArray319 */ 966, /* Empty */ 0), 
  new WarningOption(/* microsoft-end-of-file */ 6458, /* DiagArray320 */ 968, /* Empty */ 0), 
  new WarningOption(/* microsoft-enum-forward-reference */ 6480, /* DiagArray321 */ 970, /* Empty */ 0), 
  new WarningOption(/* microsoft-enum-value */ 6513, /* DiagArray322 */ 972, /* Empty */ 0), 
  new WarningOption(/* microsoft-exception-spec */ 6534, /* DiagArray323 */ 974, /* Empty */ 0), 
  new WarningOption(/* microsoft-exists */ 6559, /* DiagArray324 */ 981, /* Empty */ 0), 
  new WarningOption(/* microsoft-explicit-constructor-call */ 6576, /* DiagArray325 */ 983, /* Empty */ 0), 
  new WarningOption(/* microsoft-extra-qualification */ 6612, /* DiagArray326 */ 985, /* Empty */ 0), 
  new WarningOption(/* microsoft-fixed-enum */ 6642, /* DiagArray327 */ 987, /* Empty */ 0), 
  new WarningOption(/* microsoft-flexible-array */ 6663, /* DiagArray328 */ 989, /* Empty */ 0), 
  new WarningOption(/* microsoft-goto */ 6688, /* DiagArray329 */ 992, /* Empty */ 0), 
  new WarningOption(/* microsoft-include */ 6703, /* DiagArray330 */ 994, /* Empty */ 0), 
  new WarningOption(/* microsoft-mutable-reference */ 6721, /* DiagArray331 */ 996, /* Empty */ 0), 
  new WarningOption(/* microsoft-pure-definition */ 6749, /* DiagArray332 */ 998, /* Empty */ 0), 
  new WarningOption(/* microsoft-redeclare-static */ 6775, /* DiagArray333 */ 1000, /* Empty */ 0), 
  new WarningOption(/* microsoft-sealed */ 6802, /* DiagArray334 */ 1002, /* Empty */ 0), 
  new WarningOption(/* microsoft-template */ 6819, /* DiagArray335 */ 1004, /* Empty */ 0), 
  new WarningOption(/* microsoft-union-member-reference */ 6838, /* DiagArray336 */ 1013, /* Empty */ 0), 
  new WarningOption(/* microsoft-unqualified-friend */ 6871, /* DiagArray337 */ 1015, /* Empty */ 0), 
  new WarningOption(/* microsoft-using-decl */ 6900, /* DiagArray338 */ 1017, /* Empty */ 0), 
  new WarningOption(/* microsoft-void-pseudo-dtor */ 6921, /* DiagArray339 */ 1019, /* Empty */ 0), 
  new WarningOption(/* mismatched-new-delete */ 6948, /* DiagArray340 */ 1021, /* Empty */ 0), 
  new WarningOption(/* mismatched-parameter-types */ 6970, /* DiagArray341 */ 1023, /* Empty */ 0), 
  new WarningOption(/* mismatched-return-types */ 6997, /* DiagArray342 */ 1025, /* Empty */ 0), 
  new WarningOption(/* mismatched-tags */ 7021, /* DiagArray343 */ 1027, /* Empty */ 0), 
  new WarningOption(/* missing-braces */ 7037, /* DiagArray344 */ 1030, /* Empty */ 0), 
  new WarningOption(/* missing-declarations */ 7052, /* DiagArray345 */ 1032, /* Empty */ 0), 
  new WarningOption(/* missing-exception-spec */ 7073, /* DiagArray346 */ 1037, /* Empty */ 0), 
  new WarningOption(/* missing-field-initializers */ 7096, /* DiagArray347 */ 1039, /* Empty */ 0), 
  new WarningOption(/* missing-format-attribute */ 7123, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* missing-include-dirs */ 7148, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* missing-method-return-type */ 7169, /* DiagArray350 */ 1041, /* Empty */ 0), 
  new WarningOption(/* missing-noreturn */ 7196, /* DiagArray351 */ 1043, /* Empty */ 0), 
  new WarningOption(/* missing-prototype-for-cc */ 7213, /* DiagArray352 */ 1046, /* Empty */ 0), 
  new WarningOption(/* missing-prototypes */ 7238, /* DiagArray353 */ 1048, /* Empty */ 0), 
  new WarningOption(/* missing-selector-name */ 7257, /* DiagArray354 */ 1050, /* Empty */ 0), 
  new WarningOption(/* missing-sysroot */ 7279, /* DiagArray355 */ 1052, /* Empty */ 0), 
  new WarningOption(/* missing-variable-declarations */ 7295, /* DiagArray356 */ 1054, /* Empty */ 0), 
  new WarningOption(/* module-build */ 7325, /* DiagArray357 */ 1056, /* Empty */ 0), 
  new WarningOption(/* module-conflict */ 7338, /* DiagArray358 */ 1059, /* Empty */ 0), 
  new WarningOption(/* module-file-config-mismatch */ 7354, /* DiagArray359 */ 1061, /* Empty */ 0), 
  new WarningOption(/* module-file-extension */ 7382, /* DiagArray360 */ 1063, /* Empty */ 0), 
  new WarningOption(/* module-import-in-extern-c */ 7404, /* DiagArray361 */ 1065, /* Empty */ 0), 
  new WarningOption(/* modules-ambiguous-internal-linkage */ 7430, /* DiagArray362 */ 1067, /* Empty */ 0), 
  new WarningOption(/* modules-import-nested-redundant */ 7465, /* DiagArray363 */ 1069, /* Empty */ 0), 
  new WarningOption(/* most */ 7497, /* Empty */ 0, /* DiagSubGroup364 */ 224), 
  new WarningOption(/* move */ 7502, /* Empty */ 0, /* DiagSubGroup365 */ 254), 
  new WarningOption(/* msvc-include */ 7507, /* Empty */ 0, /* DiagSubGroup366 */ 258), 
  new WarningOption(/* multichar */ 7520, /* DiagArray367 */ 1071, /* Empty */ 0), 
  new WarningOption(/* multiple-move-vbase */ 7530, /* DiagArray368 */ 1073, /* Empty */ 0), 
  new WarningOption(/* narrowing */ 7550, /* Empty */ 0, /* DiagSubGroup369 */ 260), 
  new WarningOption(/* nested-anon-types */ 7560, /* DiagArray370 */ 1075, /* Empty */ 0), 
  new WarningOption(/* nested-externs */ 7578, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* new-returns-null */ 7593, /* DiagArray372 */ 1077, /* Empty */ 0), 
  new WarningOption(/* newline-eof */ 7610, /* DiagArray373 */ 1079, /* Empty */ 0), 
  new WarningOption(/* non-gcc */ 7622, /* Empty */ 0, /* DiagSubGroup374 */ 262), 
  new WarningOption(/* non-literal-null-conversion */ 7630, /* DiagArray375 */ 1082, /* Empty */ 0), 
  new WarningOption(/* non-modular-include-in-framework-module */ 7658, /* DiagArray376 */ 1084, /* Empty */ 0), 
  new WarningOption(/* non-modular-include-in-module */ 7698, /* DiagArray377 */ 1086, /* DiagSubGroup377 */ 266), 
  new WarningOption(/* non-pod-varargs */ 7728, /* DiagArray378 */ 1088, /* Empty */ 0), 
  new WarningOption(/* non-virtual-dtor */ 7744, /* DiagArray379 */ 1093, /* Empty */ 0), 
  new WarningOption(/* nonnull */ 7761, /* DiagArray380 */ 1095, /* Empty */ 0), 
  new WarningOption(/* nonportable-cfstrings */ 7769, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* nonportable-include-path */ 7791, /* DiagArray382 */ 1098, /* Empty */ 0), 
  new WarningOption(/* nonportable-system-include-path */ 7816, /* DiagArray383 */ 1100, /* Empty */ 0), 
  new WarningOption(/* nonportable-vector-initialization */ 7848, /* DiagArray384 */ 1102, /* Empty */ 0), 
  new WarningOption(/* null-arithmetic */ 7882, /* DiagArray385 */ 1104, /* Empty */ 0), 
  new WarningOption(/* null-character */ 7898, /* DiagArray386 */ 1107, /* Empty */ 0), 
  new WarningOption(/* null-conversion */ 7913, /* DiagArray387 */ 1110, /* Empty */ 0), 
  new WarningOption(/* null-dereference */ 7929, /* DiagArray388 */ 1112, /* Empty */ 0), 
  new WarningOption(/* nullability */ 7946, /* DiagArray389 */ 1115, /* Empty */ 0), 
  new WarningOption(/* nullability-completeness */ 7958, /* DiagArray390 */ 1121, /* Empty */ 0), 
  new WarningOption(/* nullability-declspec */ 7983, /* DiagArray391 */ 1123, /* Empty */ 0), 
  new WarningOption(/* nullability-extension */ 8004, /* DiagArray392 */ 1125, /* Empty */ 0), 
  new WarningOption(/* nullable-to-nonnull-conversion */ 8026, /* DiagArray393 */ 1127, /* Empty */ 0), 
  new WarningOption(/* objc-autosynthesis-property-ivar-name-match */ 8057, /* DiagArray394 */ 1129, /* Empty */ 0), 
  new WarningOption(/* objc-circular-container */ 8101, /* DiagArray395 */ 1131, /* Empty */ 0), 
  new WarningOption(/* objc-cocoa-api */ 8125, /* Empty */ 0, /* DiagSubGroup396 */ 268), 
  new WarningOption(/* objc-designated-initializers */ 8140, /* DiagArray397 */ 1133, /* Empty */ 0), 
  new WarningOption(/* objc-forward-class-redefinition */ 8169, /* DiagArray398 */ 1140, /* Empty */ 0), 
  new WarningOption(/* objc-interface-ivars */ 8201, /* DiagArray399 */ 1142, /* Empty */ 0), 
  new WarningOption(/* objc-literal-compare */ 8222, /* DiagArray400 */ 1144, /* DiagSubGroup400 */ 270), 
  new WarningOption(/* objc-literal-conversion */ 8243, /* DiagArray401 */ 1146, /* Empty */ 0), 
  new WarningOption(/* objc-macro-redefinition */ 8267, /* DiagArray402 */ 1149, /* Empty */ 0), 
  new WarningOption(/* objc-method-access */ 8291, /* DiagArray403 */ 1151, /* Empty */ 0), 
  new WarningOption(/* objc-missing-property-synthesis */ 8310, /* DiagArray404 */ 1158, /* Empty */ 0), 
  new WarningOption(/* objc-missing-super-calls */ 8342, /* DiagArray405 */ 1160, /* Empty */ 0), 
  new WarningOption(/* objc-multiple-method-names */ 8367, /* DiagArray406 */ 1162, /* Empty */ 0), 
  new WarningOption(/* objc-noncopy-retain-block-property */ 8394, /* DiagArray407 */ 1164, /* Empty */ 0), 
  new WarningOption(/* objc-nonunified-exceptions */ 8429, /* DiagArray408 */ 1166, /* Empty */ 0), 
  new WarningOption(/* objc-property-implementation */ 8456, /* DiagArray409 */ 1168, /* Empty */ 0), 
  new WarningOption(/* objc-property-implicit-mismatch */ 8485, /* DiagArray410 */ 1173, /* Empty */ 0), 
  new WarningOption(/* objc-property-matches-cocoa-ownership-rule */ 8517, /* DiagArray411 */ 1175, /* Empty */ 0), 
  new WarningOption(/* objc-property-no-attribute */ 8560, /* DiagArray412 */ 1177, /* Empty */ 0), 
  new WarningOption(/* objc-property-synthesis */ 8587, /* DiagArray413 */ 1180, /* Empty */ 0), 
  new WarningOption(/* objc-protocol-method-implementation */ 8611, /* DiagArray414 */ 1184, /* Empty */ 0), 
  new WarningOption(/* objc-protocol-property-synthesis */ 8647, /* DiagArray415 */ 1186, /* Empty */ 0), 
  new WarningOption(/* objc-protocol-qualifiers */ 8680, /* DiagArray416 */ 1188, /* Empty */ 0), 
  new WarningOption(/* objc-readonly-with-setter-property */ 8705, /* DiagArray417 */ 1190, /* Empty */ 0), 
  new WarningOption(/* objc-redundant-api-use */ 8740, /* Empty */ 0, /* DiagSubGroup418 */ 272), 
  new WarningOption(/* objc-redundant-literal-use */ 8763, /* DiagArray419 */ 1192, /* Empty */ 0), 
  new WarningOption(/* objc-root-class */ 8790, /* DiagArray420 */ 1194, /* Empty */ 0), 
  new WarningOption(/* objc-string-compare */ 8806, /* DiagArray421 */ 1196, /* Empty */ 0), 
  new WarningOption(/* objc-string-concatenation */ 8826, /* DiagArray422 */ 1198, /* Empty */ 0), 
  new WarningOption(/* odr */ 8852, /* DiagArray423 */ 1200, /* Empty */ 0), 
  new WarningOption(/* old-style-cast */ 8856, /* DiagArray424 */ 1202, /* Empty */ 0), 
  new WarningOption(/* old-style-definition */ 8871, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* openmp-clauses */ 8892, /* DiagArray426 */ 1204, /* Empty */ 0), 
  new WarningOption(/* openmp-loop-form */ 8907, /* DiagArray427 */ 1207, /* Empty */ 0), 
  new WarningOption(/* openmp-target */ 8924, /* DiagArray428 */ 1210, /* Empty */ 0), 
  new WarningOption(/* option-ignored */ 8938, /* DiagArray429 */ 1212, /* Empty */ 0), 
  new WarningOption(/* out-of-line-declaration */ 8953, /* DiagArray430 */ 1214, /* Empty */ 0), 
  new WarningOption(/* over-aligned */ 8977, /* DiagArray431 */ 1216, /* Empty */ 0), 
  new WarningOption(/* overflow */ 8990, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* overlength-strings */ 8999, /* DiagArray433 */ 1218, /* Empty */ 0), 
  new WarningOption(/* overloaded-shift-op-parentheses */ 9018, /* DiagArray434 */ 1220, /* Empty */ 0), 
  new WarningOption(/* overloaded-virtual */ 9050, /* DiagArray435 */ 1222, /* Empty */ 0), 
  new WarningOption(/* override-module */ 9069, /* DiagArray436 */ 1224, /* Empty */ 0), 
  new WarningOption(/* overriding-method-mismatch */ 9085, /* DiagArray437 */ 1226, /* Empty */ 0), 
  new WarningOption(/* overriding-t-option */ 9112, /* DiagArray438 */ 1234, /* Empty */ 0), 
  new WarningOption(/* packed */ 9132, /* DiagArray439 */ 1236, /* Empty */ 0), 
  new WarningOption(/* padded */ 9139, /* DiagArray440 */ 1238, /* Empty */ 0), 
  new WarningOption(/* parentheses */ 9146, /* DiagArray441 */ 1242, /* DiagSubGroup441 */ 274), 
  new WarningOption(/* parentheses-equality */ 9158, /* DiagArray442 */ 1246, /* Empty */ 0), 
  new WarningOption(/* partial-availability */ 9179, /* DiagArray443 */ 1248, /* Empty */ 0), 
  new WarningOption(/* pass */ 9200, /* DiagArray444 */ 1252, /* Empty */ 0), 
  new WarningOption(/* pass-analysis */ 9205, /* DiagArray445 */ 1254, /* Empty */ 0), 
  new WarningOption(/* pass-failed */ 9219, /* DiagArray446 */ 1258, /* Empty */ 0), 
  new WarningOption(/* pass-missed */ 9231, /* DiagArray447 */ 1260, /* Empty */ 0), 
  new WarningOption(/* pch-date-time */ 9243, /* DiagArray448 */ 1262, /* Empty */ 0), 
  new WarningOption(/* pedantic */ 9257, /* DiagArray449 */ 1264, /* DiagSubGroup449 */ 282), 
  new WarningOption(/* pedantic-core-features */ 9266, /* DiagArray450 */ 1328, /* Empty */ 0), 
  new WarningOption(/* pessimizing-move */ 9289, /* DiagArray451 */ 1330, /* Empty */ 0), 
  new WarningOption(/* pointer-arith */ 9306, /* DiagArray452 */ 1333, /* Empty */ 0), 
  new WarningOption(/* pointer-bool-conversion */ 9320, /* DiagArray453 */ 1340, /* Empty */ 0), 
  new WarningOption(/* pointer-sign */ 9344, /* DiagArray454 */ 1343, /* Empty */ 0), 
  new WarningOption(/* pointer-to-int-cast */ 9357, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* pointer-type-mismatch */ 9377, /* DiagArray456 */ 1345, /* Empty */ 0), 
  new WarningOption(/* potentially-evaluated-expression */ 9399, /* DiagArray457 */ 1347, /* Empty */ 0), 
  new WarningOption(/* pragma-once-outside-header */ 9432, /* DiagArray458 */ 1349, /* Empty */ 0), 
  new WarningOption(/* pragma-system-header-outside-header */ 9459, /* DiagArray459 */ 1351, /* Empty */ 0), 
  new WarningOption(/* pragmas */ 9495, /* DiagArray460 */ 1353, /* DiagSubGroup460 */ 335), 
  new WarningOption(/* predefined-identifier-outside-function */ 9503, /* DiagArray461 */ 1355, /* Empty */ 0), 
  new WarningOption(/* private-extern */ 9542, /* DiagArray462 */ 1357, /* Empty */ 0), 
  new WarningOption(/* private-header */ 9557, /* DiagArray463 */ 1359, /* Empty */ 0), 
  new WarningOption(/* profile-instr-out-of-date */ 9572, /* DiagArray464 */ 1361, /* Empty */ 0), 
  new WarningOption(/* profile-instr-unprofiled */ 9598, /* DiagArray465 */ 1363, /* Empty */ 0), 
  new WarningOption(/* property-access-dot-syntax */ 9623, /* DiagArray466 */ 1365, /* Empty */ 0), 
  new WarningOption(/* property-attribute-mismatch */ 9650, /* DiagArray467 */ 1367, /* Empty */ 0), 
  new WarningOption(/* protocol */ 9678, /* DiagArray468 */ 1372, /* Empty */ 0), 
  new WarningOption(/* protocol-property-synthesis-ambiguity */ 9687, /* DiagArray469 */ 1374, /* Empty */ 0), 
  new WarningOption(/* qualified-void-return-type */ 9725, /* DiagArray470 */ 1376, /* Empty */ 0), 
  new WarningOption(/* range-loop-analysis */ 9752, /* DiagArray471 */ 1378, /* Empty */ 0), 
  new WarningOption(/* readonly-iboutlet-property */ 9772, /* DiagArray472 */ 1382, /* Empty */ 0), 
  new WarningOption(/* receiver-expr */ 9799, /* DiagArray473 */ 1384, /* Empty */ 0), 
  new WarningOption(/* receiver-forward-class */ 9813, /* DiagArray474 */ 1386, /* Empty */ 0), 
  new WarningOption(/* redeclared-class-member */ 9836, /* DiagArray475 */ 1389, /* Empty */ 0), 
  new WarningOption(/* redundant-decls */ 9860, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* redundant-move */ 9876, /* DiagArray477 */ 1391, /* Empty */ 0), 
  new WarningOption(/* register */ 9891, /* DiagArray478 */ 1393, /* DiagSubGroup478 */ 338), 
  new WarningOption(/* reinterpret-base-class */ 9900, /* DiagArray479 */ 1395, /* Empty */ 0), 
  new WarningOption(/* remark-backend-plugin */ 9923, /* DiagArray480 */ 1397, /* Empty */ 0), 
  new WarningOption(/* reorder */ 9945, /* DiagArray481 */ 1399, /* Empty */ 0), 
  new WarningOption(/* requires-super-attribute */ 9953, /* DiagArray482 */ 1401, /* Empty */ 0), 
  new WarningOption(/* reserved-id-macro */ 9978, /* DiagArray483 */ 1403, /* Empty */ 0), 
  new WarningOption(/* reserved-user-defined-literal */ 9996, /* DiagArray484 */ 1405, /* DiagSubGroup484 */ 340), 
  new WarningOption(/* retained-language-linkage */ 10026, /* DiagArray485 */ 1408, /* Empty */ 0), 
  new WarningOption(/* return-stack-address */ 10052, /* DiagArray486 */ 1410, /* Empty */ 0), 
  new WarningOption(/* return-type */ 10073, /* DiagArray487 */ 1414, /* DiagSubGroup487 */ 342), 
  new WarningOption(/* return-type-c-linkage */ 10085, /* DiagArray488 */ 1422, /* Empty */ 0), 
  new WarningOption(/* rtti-for-exceptions */ 10107, /* DiagArray489 */ 1425, /* Empty */ 0), 
  new WarningOption(/* sanitize-address */ 10127, /* DiagArray490 */ 1427, /* Empty */ 0), 
  new WarningOption(/* section */ 10144, /* DiagArray491 */ 1430, /* Empty */ 0), 
  new WarningOption(/* selector */ 10152, /* DiagArray492 */ 1432, /* DiagSubGroup492 */ 344), 
  new WarningOption(/* selector-type-mismatch */ 10161, /* DiagArray493 */ 1434, /* Empty */ 0), 
  new WarningOption(/* self-assign */ 10184, /* DiagArray494 */ 1436, /* DiagSubGroup494 */ 346), 
  new WarningOption(/* self-assign-field */ 10196, /* DiagArray495 */ 1438, /* Empty */ 0), 
  new WarningOption(/* self-move */ 10214, /* DiagArray496 */ 1440, /* Empty */ 0), 
  new WarningOption(/* semicolon-before-method-body */ 10224, /* DiagArray497 */ 1442, /* Empty */ 0), 
  new WarningOption(/* sentinel */ 10253, /* DiagArray498 */ 1444, /* Empty */ 0), 
  new WarningOption(/* sequence-point */ 10262, /* Empty */ 0, /* DiagSubGroup499 */ 348), 
  new WarningOption(/* serialized-diagnostics */ 10277, /* DiagArray500 */ 1447, /* Empty */ 0), 
  new WarningOption(/* shadow */ 10300, /* DiagArray501 */ 1450, /* DiagSubGroup501 */ 350), 
  new WarningOption(/* shadow-all */ 10307, /* Empty */ 0, /* DiagSubGroup502 */ 352), 
  new WarningOption(/* shadow-field-in-constructor */ 10318, /* DiagArray503 */ 1452, /* DiagSubGroup503 */ 355), 
  new WarningOption(/* shadow-field-in-constructor-modified */ 10346, /* DiagArray504 */ 1454, /* Empty */ 0), 
  new WarningOption(/* shadow-ivar */ 10383, /* DiagArray505 */ 1456, /* Empty */ 0), 
  new WarningOption(/* shift-count-negative */ 10395, /* DiagArray506 */ 1458, /* Empty */ 0), 
  new WarningOption(/* shift-count-overflow */ 10416, /* DiagArray507 */ 1460, /* Empty */ 0), 
  new WarningOption(/* shift-negative-value */ 10437, /* DiagArray508 */ 1462, /* Empty */ 0), 
  new WarningOption(/* shift-op-parentheses */ 10458, /* DiagArray509 */ 1464, /* Empty */ 0), 
  new WarningOption(/* shift-overflow */ 10479, /* DiagArray510 */ 1466, /* Empty */ 0), 
  new WarningOption(/* shift-sign-overflow */ 10494, /* DiagArray511 */ 1468, /* Empty */ 0), 
  new WarningOption(/* shorten-64-to-32 */ 10514, /* DiagArray512 */ 1470, /* Empty */ 0), 
  new WarningOption(/* sign-compare */ 10531, /* DiagArray513 */ 1472, /* Empty */ 0), 
  new WarningOption(/* sign-conversion */ 10544, /* DiagArray514 */ 1474, /* Empty */ 0), 
  new WarningOption(/* sign-promo */ 10560, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* sizeof-array-argument */ 10571, /* DiagArray516 */ 1477, /* Empty */ 0), 
  new WarningOption(/* sizeof-array-decay */ 10593, /* DiagArray517 */ 1479, /* Empty */ 0), 
  new WarningOption(/* sizeof-pointer-memaccess */ 10612, /* DiagArray518 */ 1481, /* Empty */ 0), 
  new WarningOption(/* sometimes-uninitialized */ 10637, /* DiagArray519 */ 1484, /* Empty */ 0), 
  new WarningOption(/* source-uses-openmp */ 10661, /* DiagArray520 */ 1486, /* Empty */ 0), 
  new WarningOption(/* stack-protector */ 10680, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* static-float-init */ 10696, /* DiagArray522 */ 1489, /* DiagSubGroup522 */ 357), 
  new WarningOption(/* static-in-inline */ 10714, /* DiagArray523 */ 1491, /* Empty */ 0), 
  new WarningOption(/* static-inline-explicit-instantiation */ 10731, /* DiagArray524 */ 1494, /* Empty */ 0), 
  new WarningOption(/* static-local-in-inline */ 10768, /* DiagArray525 */ 1496, /* Empty */ 0), 
  new WarningOption(/* static-self-init */ 10791, /* DiagArray526 */ 1498, /* Empty */ 0), 
  new WarningOption(/* strict-aliasing */ 10808, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-aliasing=0 */ 10824, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-aliasing=1 */ 10842, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-aliasing=2 */ 10860, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow */ 10878, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=0 */ 10894, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=1 */ 10912, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=2 */ 10930, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=3 */ 10948, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=4 */ 10966, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-overflow=5 */ 10984, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-prototypes */ 11002, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* strict-selector-match */ 11020, /* DiagArray539 */ 1500, /* Empty */ 0), 
  new WarningOption(/* string-compare */ 11042, /* DiagArray540 */ 1502, /* Empty */ 0), 
  new WarningOption(/* string-conversion */ 11057, /* DiagArray541 */ 1504, /* Empty */ 0), 
  new WarningOption(/* string-plus-char */ 11075, /* DiagArray542 */ 1506, /* Empty */ 0), 
  new WarningOption(/* string-plus-int */ 11092, /* DiagArray543 */ 1508, /* Empty */ 0), 
  new WarningOption(/* strlcpy-strlcat-size */ 11108, /* DiagArray544 */ 1510, /* Empty */ 0), 
  new WarningOption(/* strncat-size */ 11129, /* DiagArray545 */ 1512, /* Empty */ 0), 
  new WarningOption(/* super-class-method-mismatch */ 11142, /* DiagArray546 */ 1516, /* Empty */ 0), 
  new WarningOption(/* switch */ 11170, /* DiagArray547 */ 1518, /* Empty */ 0), 
  new WarningOption(/* switch-bool */ 11177, /* DiagArray548 */ 1522, /* Empty */ 0), 
  new WarningOption(/* switch-default */ 11189, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* switch-enum */ 11204, /* DiagArray550 */ 1524, /* Empty */ 0), 
  new WarningOption(/* sync-fetch-and-nand-semantics-changed */ 11216, /* DiagArray551 */ 1526, /* Empty */ 0), 
  new WarningOption(/* synth */ 11254, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* tautological-compare */ 11260, /* DiagArray553 */ 1528, /* DiagSubGroup553 */ 359), 
  new WarningOption(/* tautological-constant-out-of-range-compare */ 11281, /* DiagArray554 */ 1533, /* Empty */ 0), 
  new WarningOption(/* tautological-overlap-compare */ 11324, /* DiagArray555 */ 1535, /* Empty */ 0), 
  new WarningOption(/* tautological-pointer-compare */ 11353, /* DiagArray556 */ 1537, /* Empty */ 0), 
  new WarningOption(/* tautological-undefined-compare */ 11382, /* DiagArray557 */ 1540, /* Empty */ 0), 
  new WarningOption(/* tentative-definition-incomplete-type */ 11413, /* DiagArray558 */ 1543, /* Empty */ 0), 
  new WarningOption(/* thread-safety */ 11450, /* Empty */ 0, /* DiagSubGroup559 */ 364), 
  new WarningOption(/* thread-safety-analysis */ 11464, /* DiagArray560 */ 1545, /* Empty */ 0), 
  new WarningOption(/* thread-safety-attributes */ 11487, /* DiagArray561 */ 1563, /* Empty */ 0), 
  new WarningOption(/* thread-safety-beta */ 11512, /* DiagArray562 */ 1569, /* Empty */ 0), 
  new WarningOption(/* thread-safety-negative */ 11531, /* DiagArray563 */ 1571, /* Empty */ 0), 
  new WarningOption(/* thread-safety-precise */ 11554, /* DiagArray564 */ 1573, /* Empty */ 0), 
  new WarningOption(/* thread-safety-reference */ 11576, /* DiagArray565 */ 1577, /* Empty */ 0), 
  new WarningOption(/* thread-safety-verbose */ 11600, /* DiagArray566 */ 1580, /* Empty */ 0), 
  new WarningOption(/* trigraphs */ 11622, /* DiagArray567 */ 1582, /* Empty */ 0), 
  new WarningOption(/* type-limits */ 11632, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* type-safety */ 11644, /* DiagArray569 */ 1587, /* Empty */ 0), 
  new WarningOption(/* typedef-redefinition */ 11656, /* DiagArray570 */ 1591, /* Empty */ 0), 
  new WarningOption(/* typename-missing */ 11677, /* DiagArray571 */ 1593, /* Empty */ 0), 
  new WarningOption(/* unavailable-declarations */ 11694, /* DiagArray572 */ 1595, /* Empty */ 0), 
  new WarningOption(/* undeclared-selector */ 11719, /* DiagArray573 */ 1597, /* Empty */ 0), 
  new WarningOption(/* undef */ 11739, /* DiagArray574 */ 1600, /* Empty */ 0), 
  new WarningOption(/* undefined-bool-conversion */ 11745, /* DiagArray575 */ 1602, /* Empty */ 0), 
  new WarningOption(/* undefined-func-template */ 11771, /* DiagArray576 */ 1605, /* Empty */ 0), 
  new WarningOption(/* undefined-inline */ 11795, /* DiagArray577 */ 1607, /* Empty */ 0), 
  new WarningOption(/* undefined-internal */ 11812, /* DiagArray578 */ 1609, /* Empty */ 0), 
  new WarningOption(/* undefined-reinterpret-cast */ 11831, /* DiagArray579 */ 1611, /* Empty */ 0), 
  new WarningOption(/* undefined-var-template */ 11858, /* DiagArray580 */ 1614, /* Empty */ 0), 
  new WarningOption(/* unevaluated-expression */ 11881, /* DiagArray581 */ 1616, /* DiagSubGroup581 */ 369), 
  new WarningOption(/* unguarded-availability */ 11904, /* DiagArray582 */ 1618, /* Empty */ 0), 
  new WarningOption(/* unicode */ 11927, /* DiagArray583 */ 1620, /* Empty */ 0), 
  new WarningOption(/* unicode-whitespace */ 11935, /* DiagArray584 */ 1626, /* Empty */ 0), 
  new WarningOption(/* uninitialized */ 11954, /* DiagArray585 */ 1628, /* DiagSubGroup585 */ 371), 
  new WarningOption(/* unknown-argument */ 11968, /* DiagArray586 */ 1636, /* Empty */ 0), 
  new WarningOption(/* unknown-attributes */ 11985, /* DiagArray587 */ 1638, /* Empty */ 0), 
  new WarningOption(/* unknown-escape-sequence */ 12004, /* DiagArray588 */ 1640, /* Empty */ 0), 
  new WarningOption(/* unknown-pragmas */ 12028, /* DiagArray589 */ 1642, /* Empty */ 0), 
  new WarningOption(/* unknown-sanitizers */ 12044, /* DiagArray590 */ 1661, /* Empty */ 0), 
  new WarningOption(/* unknown-warning-option */ 12063, /* DiagArray591 */ 1663, /* Empty */ 0), 
  new WarningOption(/* unnamed-type-template-args */ 12086, /* DiagArray592 */ 1666, /* DiagSubGroup592 */ 374), 
  new WarningOption(/* unneeded-internal-declaration */ 12113, /* DiagArray593 */ 1668, /* Empty */ 0), 
  new WarningOption(/* unneeded-member-function */ 12143, /* DiagArray594 */ 1671, /* Empty */ 0), 
  new WarningOption(/* unreachable-code */ 12168, /* DiagArray595 */ 1673, /* DiagSubGroup595 */ 376), 
  new WarningOption(/* unreachable-code-aggressive */ 12185, /* Empty */ 0, /* DiagSubGroup596 */ 378), 
  new WarningOption(/* unreachable-code-break */ 12213, /* DiagArray597 */ 1675, /* Empty */ 0), 
  new WarningOption(/* unreachable-code-loop-increment */ 12236, /* DiagArray598 */ 1677, /* Empty */ 0), 
  new WarningOption(/* unreachable-code-return */ 12268, /* DiagArray599 */ 1679, /* Empty */ 0), 
  new WarningOption(/* unsequenced */ 12292, /* DiagArray600 */ 1681, /* Empty */ 0), 
  new WarningOption(/* unsupported-cb */ 12304, /* DiagArray601 */ 1684, /* Empty */ 0), 
  new WarningOption(/* unsupported-dll-base-class-template */ 12319, /* DiagArray602 */ 1686, /* Empty */ 0), 
  new WarningOption(/* unsupported-friend */ 12355, /* DiagArray603 */ 1688, /* Empty */ 0), 
  new WarningOption(/* unsupported-nan */ 12374, /* DiagArray604 */ 1691, /* Empty */ 0), 
  new WarningOption(/* unsupported-visibility */ 12390, /* DiagArray605 */ 1694, /* Empty */ 0), 
  new WarningOption(/* unused */ 12413, /* Empty */ 0, /* DiagSubGroup606 */ 382), 
  new WarningOption(/* unused-argument */ 12420, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* unused-command-line-argument */ 12436, /* DiagArray608 */ 1696, /* Empty */ 0), 
  new WarningOption(/* unused-comparison */ 12465, /* DiagArray609 */ 1702, /* Empty */ 0), 
  new WarningOption(/* unused-const-variable */ 12483, /* DiagArray610 */ 1704, /* Empty */ 0), 
  new WarningOption(/* unused-exception-parameter */ 12505, /* DiagArray611 */ 1706, /* Empty */ 0), 
  new WarningOption(/* unused-function */ 12532, /* DiagArray612 */ 1708, /* DiagSubGroup612 */ 391), 
  new WarningOption(/* unused-getter-return-value */ 12548, /* DiagArray613 */ 1710, /* Empty */ 0), 
  new WarningOption(/* unused-label */ 12575, /* DiagArray614 */ 1712, /* Empty */ 0), 
  new WarningOption(/* unused-local-typedef */ 12588, /* DiagArray615 */ 1714, /* Empty */ 0), 
  new WarningOption(/* unused-local-typedefs */ 12609, /* Empty */ 0, /* DiagSubGroup616 */ 393), 
  new WarningOption(/* unused-macros */ 12631, /* DiagArray617 */ 1716, /* Empty */ 0), 
  new WarningOption(/* unused-member-function */ 12645, /* DiagArray618 */ 1718, /* DiagSubGroup618 */ 395), 
  new WarningOption(/* unused-parameter */ 12668, /* DiagArray619 */ 1720, /* Empty */ 0), 
  new WarningOption(/* unused-private-field */ 12685, /* DiagArray620 */ 1722, /* Empty */ 0), 
  new WarningOption(/* unused-property-ivar */ 12706, /* DiagArray621 */ 1724, /* Empty */ 0), 
  new WarningOption(/* unused-result */ 12727, /* DiagArray622 */ 1726, /* Empty */ 0), 
  new WarningOption(/* unused-value */ 12741, /* DiagArray623 */ 1728, /* DiagSubGroup623 */ 397), 
  new WarningOption(/* unused-variable */ 12754, /* DiagArray624 */ 1733, /* DiagSubGroup624 */ 401), 
  new WarningOption(/* unused-volatile-lvalue */ 12770, /* DiagArray625 */ 1735, /* Empty */ 0), 
  new WarningOption(/* used-but-marked-unused */ 12793, /* DiagArray626 */ 1737, /* Empty */ 0), 
  new WarningOption(/* user-defined-literals */ 12816, /* DiagArray627 */ 1739, /* Empty */ 0), 
  new WarningOption(/* varargs */ 12838, /* DiagArray628 */ 1741, /* Empty */ 0), 
  new WarningOption(/* variadic-macros */ 12846, /* DiagArray629 */ 1745, /* Empty */ 0), 
  new WarningOption(/* vector-conversion */ 12862, /* DiagArray630 */ 1748, /* Empty */ 0), 
  new WarningOption(/* vector-conversions */ 12880, /* Empty */ 0, /* DiagSubGroup631 */ 403), 
  new WarningOption(/* vexing-parse */ 12899, /* DiagArray632 */ 1750, /* Empty */ 0), 
  new WarningOption(/* visibility */ 12912, /* DiagArray633 */ 1753, /* Empty */ 0), 
  new WarningOption(/* vla */ 12923, /* DiagArray634 */ 1756, /* Empty */ 0), 
  new WarningOption(/* vla-extension */ 12927, /* DiagArray635 */ 1758, /* Empty */ 0), 
  new WarningOption(/* void-ptr-dereference */ 12941, /* DiagArray636 */ 1760, /* Empty */ 0), 
  new WarningOption(/* volatile-register-var */ 12962, /* Empty */ 0, /* Empty */ 0), 
  new WarningOption(/* weak-template-vtables */ 12984, /* DiagArray638 */ 1762, /* Empty */ 0), 
  new WarningOption(/* weak-vtables */ 13006, /* DiagArray639 */ 1764, /* Empty */ 0), 
  new WarningOption(/* writable-strings */ 13019, /* DiagArray640 */ 1766, /* DiagSubGroup640 */ 405), 
  new WarningOption(/* write-strings */ 13036, /* Empty */ 0, /* DiagSubGroup641 */ 407), 
  new WarningOption(/* zero-length-array */ 13050, /* DiagArray642 */ 1768, /* Empty */ 0)
};

/// Return \c true if any diagnostics were found in this group, even if they
/// were filtered out due to having the wrong flavor.
//<editor-fold defaultstate="collapsed" desc="getDiagnosticsInGroup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 522,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 516,
 FQN="getDiagnosticsInGroup", NM="_ZL21getDiagnosticsInGroupN5clang4diag6FlavorEPKN12_GLOBAL__N_113WarningOptionERN4llvm15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL21getDiagnosticsInGroupN5clang4diag6FlavorEPKN12_GLOBAL__N_113WarningOptionERN4llvm15SmallVectorImplIjEE")
//</editor-fold>
public static boolean getDiagnosticsInGroup(diag.Flavor Flavor, 
                     /*const*/ WarningOption /*P*/ Group, 
                     SmallVectorImplUInt/*<diag.kind>*//*&*/ Diags) {
  // An empty group is considered to be a warning group: we have empty groups
  // for GCC compatibility, and GCC does not have remarks.
  if (!(Group.Members != 0) && !(Group.SubGroups != 0)) {
    return Flavor == diag.Flavor.Remark;
  }
  
  boolean NotFound = true;
  
  // JAVA MANUAL_SEMANTIC: iterate using array
  // Add the members of the option diagnostic set.
  for (int i = Group.Members; DiagArrays[i] != (short)-1; ++i) {
  /*const*/short/*int16_t*//*P*/ Member = DiagArrays[i];
    if (GetDiagInfo(Member).getFlavor() == Flavor) {
      NotFound = false;
      Diags.push_back(Member);
    }
  }
  
  // JAVA MANUAL_SEMANTIC: iterate using array
  // Add the members of the subgroups.
//  /*const*/short/*int16_t*//*P*/ SubGroups = DiagSubGroups[Group.SubGroups];
  for (int i = Group.SubGroups; DiagSubGroups[i] != (short)-1; ++i)  {
    NotFound &= getDiagnosticsInGroup(Flavor, $AddrOf(OptionTable[DiagSubGroups[i]]), 
        Diags);
  }
  
  return NotFound;
}

} // END OF class DiagnosticIDsStatics
