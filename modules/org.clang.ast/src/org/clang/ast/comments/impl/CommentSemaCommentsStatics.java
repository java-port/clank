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
package org.clang.ast.comments.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.comments.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type CommentSemaCommentsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE;_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE;_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE; -static-type=CommentSemaCommentsStatics -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentSemaCommentsStatics {


/// \brief Turn a string into the corresponding PassDirection or -1 if it's not
/// valid.
//<editor-fold defaultstate="collapsed" desc="clang::comments::getParamPassDirection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 220,
 FQN="clang::comments::getParamPassDirection", NM="_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8commentsL21getParamPassDirectionEN4llvm9StringRefE")
//</editor-fold>
public static int getParamPassDirection(StringRef Arg) {
  return new StringSwitchInt(/*NO_COPY*/Arg).
      Case(/*KEEP_STR*/"[in]", ParamCommandComment.PassDirection.In.getValue()).
      Case(/*KEEP_STR*/"[out]", ParamCommandComment.PassDirection.Out.getValue()).
      Cases(/*KEEP_STR*/"[in,out]", /*KEEP_STR*/"[out,in]", ParamCommandComment.PassDirection.InOut.getValue()).
      Default(-1);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::ResolveTParamReferenceHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1018,
 FQN="clang::comments::(anonymous namespace)::ResolveTParamReferenceHelper", NM="_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_128ResolveTParamReferenceHelperEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE")
//</editor-fold>
public static boolean ResolveTParamReferenceHelper(StringRef Name, 
                            /*const*/ TemplateParameterList /*P*/ TemplateParameters, 
                            SmallVectorImplUInt/*P*/ Position) {
  for (/*uint*/int i = 0, e = TemplateParameters.size(); i != e; ++i) {
    /*const*/ NamedDecl /*P*/ Param = TemplateParameters.getParam$Const(i);
    /*const*/ IdentifierInfo /*P*/ II = Param.getIdentifier();
    if ((II != null) && $eq_StringRef(II.getName(), /*NO_COPY*/Name)) {
      Position.push_back(i);
      return true;
    }
    {
      
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
      if ((TTP != null)) {
        Position.push_back(i);
        if (ResolveTParamReferenceHelper(new StringRef(Name), TTP.getTemplateParameters(), 
            Position)) {
          return true;
        }
        Position.pop_back();
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::CorrectTypoInTParamReferenceHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1055,
 FQN="clang::comments::(anonymous namespace)::CorrectTypoInTParamReferenceHelper", NM="_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_134CorrectTypoInTParamReferenceHelperEPKNS_21TemplateParameterListERNS1_19SimpleTypoCorrectorE")
//</editor-fold>
public static void CorrectTypoInTParamReferenceHelper(/*const*/ TemplateParameterList /*P*/ TemplateParameters, 
                                  final SimpleTypoCorrector /*&*/ Corrector) {
  for (/*uint*/int i = 0, e = TemplateParameters.size(); i != e; ++i) {
    /*const*/ NamedDecl /*P*/ Param = TemplateParameters.getParam$Const(i);
    Corrector.addDecl(Param);
    {
      
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
      if ((TTP != null)) {
        CorrectTypoInTParamReferenceHelper(TTP.getTemplateParameters(), 
            Corrector);
      }
    }
  }
}

} // END OF class CommentSemaCommentsStatics
