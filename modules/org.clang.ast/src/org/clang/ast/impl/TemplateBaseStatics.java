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
package org.clang.ast.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_APSInt$C;


//<editor-fold defaultstate="collapsed" desc="static type TemplateBaseStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZL13printIntegralRKN5clang16TemplateArgumentERN4llvm11raw_ostreamERKNS_14PrintingPolicyE; -static-type=TemplateBaseStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class TemplateBaseStatics {


/// \brief Print a template integral argument value.
///
/// \param TemplArg the TemplateArgument instance to print.
///
/// \param Out the raw_ostream instance to use for printing.
///
/// \param Policy the printing policy for EnumConstantDecl printing.
//<editor-fold defaultstate="collapsed" desc="printIntegral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 38,
 FQN="printIntegral", NM="_ZL13printIntegralRKN5clang16TemplateArgumentERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZL13printIntegralRKN5clang16TemplateArgumentERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
//</editor-fold>
public static void printIntegral(final /*const*/ TemplateArgument /*&*/ TemplArg, 
             final raw_ostream /*&*/ Out, final /*const*/ PrintingPolicy /*&*/ Policy) {
  /*const*/ /*::*/Type /*P*/ T = TemplArg.getIntegralType().getTypePtr();
  final /*const*/ APSInt /*&*/ Val = TemplArg.getAsIntegral();
  {
    
    /*const*/ EnumType /*P*/ ET = T.<EnumType>getAs$EnumType();
    if ((ET != null)) {
      for (/*const*/ EnumConstantDecl /*P*/ ECD : ET.getDecl().enumerators()) {
        // In Sema::CheckTemplateArugment, enum template arguments value are
        // extended to the size of the integer underlying the enum type.  This
        // may create a size difference between the enum value and template
        // argument value, requiring isSameValue here instead of operator==.
        if (APSInt.isSameValue(ECD.getInitVal(), Val)) {
          ECD.printQualifiedName(Out, Policy);
          return;
        }
      }
    }
  }
  if (T.isBooleanType() && !Policy.MSVCFormatting) {
    Out.$out((Val.getBoolValue() ? $true : $false));
  } else if (T.isCharType()) {
    /*const*//*char*/byte Ch = $ulong2char(Val.getZExtValue());
    Out.$out(((Ch == $$SGL_QUOTE) ? $("'\\") : $SGL_QUOTE));
    Out.write_escaped(new StringRef(new byte[]/*AddrOf*/{Ch}, 1), /*UseHexEscapes=*/ true);
    Out.$out(/*KEEP_STR*/$SGL_QUOTE);
  } else {
    $out_raw_ostream_APSInt$C(Out, Val);
  }
}

} // END OF class TemplateBaseStatics
