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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type TemplateBaseClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE; -static-type=TemplateBaseClangGlobals -package=org.clang.ast.impl")
//</editor-fold>
public final class TemplateBaseClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 475,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_TemplateArgument$C(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                           final /*const*/ TemplateArgument /*&*/ Arg) {
  switch (Arg.getKind()) {
   case Null:
    // This is bad, but not as bad as crashing because of argument
    // count mismatches.
    return $out_DiagnosticBuilder$C_char$ptr$C(DB, /*KEEP_STR*/"(null template argument)");
   case Type:
    return $out_DiagnosticBuilder$C_QualType(DB, Arg.getAsType());
   case Declaration:
    return $out_DiagnosticBuilder$C_NamedDecl$C$P(DB, Arg.getAsDecl());
   case NullPtr:
    return $out_DiagnosticBuilder$C_char$ptr$C(DB, /*KEEP_STR*/$nullptr);
   case Integral:
    return $out_DiagnosticBuilder$C_StringRef(DB, new StringRef(Arg.getAsIntegral().__toString(10)));
   case Template:
    return $out_DiagnosticBuilder$C_TemplateName(DB, Arg.getAsTemplate());
   case TemplateExpansion:
    return $out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_TemplateName(DB, Arg.getAsTemplateOrTemplatePattern()), /*KEEP_STR*/$ELLIPSIS);
   case Expression:
    {
      raw_svector_ostream OS = null;
      try {
        // This shouldn't actually ever happen, so it's okay that we're
        // regurgitating an expression here.
        // FIXME: We're guessing at LangOptions!
        SmallString/*32*/ Str/*J*/= new SmallString/*32*/(32);
        OS/*J*/= new raw_svector_ostream(Str);
        LangOptions LangOpts/*J*/= new LangOptions();
        LangOpts.CPlusPlus = true;
        PrintingPolicy Policy/*J*/= new PrintingPolicy(LangOpts);
        Arg.getAsExpr().printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        return $out_DiagnosticBuilder$C_StringRef(DB, OS.str());
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
   case Pack:
    {
      raw_svector_ostream OS = null;
      try {
        // FIXME: We're guessing at LangOptions!
        SmallString/*32*/ Str/*J*/= new SmallString/*32*/(32);
        OS/*J*/= new raw_svector_ostream(Str);
        LangOptions LangOpts/*J*/= new LangOptions();
        LangOpts.CPlusPlus = true;
        PrintingPolicy Policy/*J*/= new PrintingPolicy(LangOpts);
        Arg.print(Policy, OS);
        return $out_DiagnosticBuilder$C_StringRef(DB, OS.str());
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}

} // END OF class TemplateBaseClangGlobals
