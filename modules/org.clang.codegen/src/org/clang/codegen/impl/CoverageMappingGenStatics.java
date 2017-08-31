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
package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.profiledata.coverage.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CoverageMappingGenStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZL18getCoverageSectionRKN5clang7CodeGen13CodeGenModuleE;_ZL4dumpRN4llvm11raw_ostreamENS_9StringRefENS_8ArrayRefINS_8coverage17CounterExpressionEEENS3_INS4_20CounterMappingRegionEEE;_ZL7isMachORKN5clang7CodeGen13CodeGenModuleE; -static-type=CoverageMappingGenStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CoverageMappingGenStatics {

//<editor-fold defaultstate="collapsed" desc="isMachO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 936,
 FQN="isMachO", NM="_ZL7isMachORKN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZL7isMachORKN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static boolean isMachO(final /*const*/ CodeGenModule /*&*/ CGM) {
  return CGM.getTarget().getTriple().isOSBinFormatMachO();
}

//<editor-fold defaultstate="collapsed" desc="getCoverageSection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 940,
 FQN="getCoverageSection", NM="_ZL18getCoverageSectionRKN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZL18getCoverageSectionRKN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static StringRef getCoverageSection(final /*const*/ CodeGenModule /*&*/ CGM) {
  return CoverageGlobals.getInstrProfCoverageSectionName(isMachO(CGM));
}

//<editor-fold defaultstate="collapsed" desc="dump">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 944,
 FQN="dump", NM="_ZL4dumpRN4llvm11raw_ostreamENS_9StringRefENS_8ArrayRefINS_8coverage17CounterExpressionEEENS3_INS4_20CounterMappingRegionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZL4dumpRN4llvm11raw_ostreamENS_9StringRefENS_8ArrayRefINS_8coverage17CounterExpressionEEENS3_INS4_20CounterMappingRegionEEE")
//</editor-fold>
public static void dump(final raw_ostream /*&*/ OS, StringRef FunctionName, 
    ArrayRef<CounterExpression> Expressions, 
    ArrayRef<CounterMappingRegion> Regions) {
  OS.$out(/*NO_COPY*/FunctionName).$out(/*KEEP_STR*/$COLON_LF);
  CounterMappingContext Ctx/*J*/= new CounterMappingContext(new ArrayRef<CounterExpression>(Expressions));
  for (final /*const*/ CounterMappingRegion /*&*/ R : Regions) {
    OS.indent(2);
    switch (R.Kind) {
     case CodeRegion:
      break;
     case ExpansionRegion:
      OS.$out(/*KEEP_STR*/"Expansion,");
      break;
     case SkippedRegion:
      OS.$out(/*KEEP_STR*/"Skipped,");
      break;
    }
    
    OS.$out(/*KEEP_STR*/"File ").$out_uint(R.FileID).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(R.LineStart).$out(/*KEEP_STR*/$COLON).$out_uint(R.ColumnStart).$out(
        /*KEEP_STR*/" -> "
    ).$out_uint(R.LineEnd).$out(/*KEEP_STR*/$COLON).$out_uint(R.ColumnEnd).$out(/*KEEP_STR*/" = ");
    Ctx.dump(R.Count, OS);
    if (R.Kind == CounterMappingRegion.RegionKind.ExpansionRegion) {
      OS.$out(/*KEEP_STR*/" (Expanded file = ").$out_uint(R.ExpandedFileID).$out(/*KEEP_STR*/$RPAREN);
    }
    OS.$out(/*KEEP_STR*/$LF);
  }
}

} // END OF class CoverageMappingGenStatics
