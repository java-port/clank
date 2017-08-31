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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type MicrosoftMangleStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE;_ZL25mangleThunkThisAdjustmentPKN5clang13CXXMethodDeclERKNS_14ThisAdjustmentERN12_GLOBAL__N_123MicrosoftCXXNameManglerERN4llvm11raw_ostreamE;_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE;_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE;_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE; -static-type=MicrosoftMangleStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class MicrosoftMangleStatics {


/// \brief Retrieve the declaration context that should be used when mangling
/// the given declaration.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getEffectiveDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 71,
 FQN="(anonymous namespace)::getEffectiveDeclContext", NM="_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ getEffectiveDeclContext(/*const*/ Decl /*P*/ D) {
  {
    // The ABI assumes that lambda closure types that occur within
    // default arguments live in the context of the function. However, due to
    // the way in which Clang parses and creates function declarations, this is
    // not the case: the lambda closure type ends up living in the context
    // where the function itself resides, because the function declaration itself
    // had not yet been created. Fix the context here.
    /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
    if ((RD != null)) {
      if (RD.isLambda()) {
        {
          ParmVarDecl /*P*/ ContextParam = dyn_cast_or_null_ParmVarDecl(RD.getLambdaContextDecl());
          if ((ContextParam != null)) {
            return ContextParam.getDeclContext();
          }
        }
      }
    }
  }
  {
    
    // Perform the same check for block literals.
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      {
        ParmVarDecl /*P*/ ContextParam = dyn_cast_or_null_ParmVarDecl(BD.getBlockManglingContextDecl());
        if ((ContextParam != null)) {
          return ContextParam.getDeclContext();
        }
      }
    }
  }
  
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  if (isa_CapturedDecl(DC) || isa_OMPDeclareReductionDecl(DC)) {
    return getEffectiveDeclContext(cast_Decl(DC));
  }
  
  return DC.getRedeclContext$Const();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getEffectiveParentContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 100,
 FQN="(anonymous namespace)::getEffectiveParentContext", NM="_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ getEffectiveParentContext(/*const*/ DeclContext /*P*/ DC) {
  return getEffectiveDeclContext(cast_Decl(DC));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getStructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 104,
 FQN="(anonymous namespace)::getStructor", NM="_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE")
//</editor-fold>
public static /*const*/ FunctionDecl /*P*/ getStructor(/*const*/ NamedDecl /*P*/ ND) {
  {
    /*const*/ FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ND);
    if ((FTD != null)) {
      return FTD.getTemplatedDecl();
    }
  }
  
  /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(ND);
  {
    /*const*/ FunctionTemplateDecl /*P*/ FTD = FD.getPrimaryTemplate();
    if ((FTD != null)) {
      return FTD.getTemplatedDecl();
    }
  }
  
  return FD;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 115,
 FQN="(anonymous namespace)::isLambda", NM="_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean isLambda(/*const*/ NamedDecl /*P*/ ND) {
  /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(ND);
  if (!(Record != null)) {
    return false;
  }
  
  return Record.isLambda();
}

//<editor-fold defaultstate="collapsed" desc="isTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 696,
 FQN="isTemplate", NM="_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE")
//</editor-fold>
public static /*const*/ TemplateDecl /*P*/ isTemplate(/*const*/ NamedDecl /*P*/ ND, final type$ref</*const*/ TemplateArgumentList /*P*/ /*&*/> TemplateArgs) {
  {
    // Check if we have a function template.
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      {
        /*const*/ TemplateDecl /*P*/ TD = FD.getPrimaryTemplate();
        if ((TD != null)) {
          TemplateArgs.$set(FD.getTemplateSpecializationArgs());
          return TD;
        }
      }
    }
  }
  {
    
    // Check if we have a class template.
    /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(ND);
    if ((Spec != null)) {
      TemplateArgs.$set($AddrOf(Spec.getTemplateArgs()));
      return Spec.getSpecializedTemplate();
    }
  }
  {
    
    // Check if we have a variable template.
    /*const*/ VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(ND);
    if ((Spec != null)) {
      TemplateArgs.$set($AddrOf(Spec.getTemplateArgs()));
      return Spec.getSpecializedTemplate();
    }
  }
  
  return null;
}


// <this-adjustment> ::= <no-adjustment> | <static-adjustment> |
//                       <virtual-adjustment>
// <no-adjustment>      ::= A # private near
//                      ::= B # private far
//                      ::= I # protected near
//                      ::= J # protected far
//                      ::= Q # public near
//                      ::= R # public far
// <static-adjustment>  ::= G <static-offset> # private near
//                      ::= H <static-offset> # private far
//                      ::= O <static-offset> # protected near
//                      ::= P <static-offset> # protected far
//                      ::= W <static-offset> # public near
//                      ::= X <static-offset> # public far
// <virtual-adjustment> ::= $0 <virtual-shift> <static-offset> # private near
//                      ::= $1 <virtual-shift> <static-offset> # private far
//                      ::= $2 <virtual-shift> <static-offset> # protected near
//                      ::= $3 <virtual-shift> <static-offset> # protected far
//                      ::= $4 <virtual-shift> <static-offset> # public near
//                      ::= $5 <virtual-shift> <static-offset> # public far
// <virtual-shift>      ::= <vtordisp-shift> | <vtordispex-shift>
// <vtordisp-shift>     ::= <offset-to-vtordisp>
// <vtordispex-shift>   ::= <offset-to-vbptr> <vbase-offset-offset>
//                          <offset-to-vtordisp>
//<editor-fold defaultstate="collapsed" desc="mangleThunkThisAdjustment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2486,
 FQN="mangleThunkThisAdjustment", NM="_ZL25mangleThunkThisAdjustmentPKN5clang13CXXMethodDeclERKNS_14ThisAdjustmentERN12_GLOBAL__N_123MicrosoftCXXNameManglerERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZL25mangleThunkThisAdjustmentPKN5clang13CXXMethodDeclERKNS_14ThisAdjustmentERN12_GLOBAL__N_123MicrosoftCXXNameManglerERN4llvm11raw_ostreamE")
//</editor-fold>
public static void mangleThunkThisAdjustment(/*const*/ CXXMethodDecl /*P*/ MD, 
                         final /*const*/ ThisAdjustment /*&*/ Adjustment, 
                         final MicrosoftCXXNameMangler /*&*/ Mangler, 
                         final raw_ostream /*&*/ Out) {
  if (!Adjustment.Virtual.isEmpty()) {
    Out.$out_char($$DOLLAR);
    /*char*/byte AccessSpec;
    switch (MD.getAccess()) {
      default:
     case AS_none:
      throw new llvm_unreachable("Unsupported access specifier");
     case AS_private:
      AccessSpec = $$0;
      break;
     case AS_protected:
      AccessSpec = $$2;
      break;
     case AS_public:
      AccessSpec = $$4;
    }
    if ((Adjustment.Virtual.Microsoft.VBPtrOffset != 0)) {
      Out.$out_char($$R).$out_char(AccessSpec);
      Mangler.mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)(Adjustment.Virtual.Microsoft.VBPtrOffset))));
      Mangler.mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)(Adjustment.Virtual.Microsoft.VBOffsetOffset))));
      Mangler.mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)(Adjustment.Virtual.Microsoft.VtordispOffset))));
      Mangler.mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)($long2uint(Adjustment.NonVirtual)))));
    } else {
      Out.$out_char(AccessSpec);
      Mangler.mangleNumber($uint2long(((/*static_cast*//*uint32_t*/int)(Adjustment.Virtual.Microsoft.VtordispOffset))));
      Mangler.mangleNumber($uint2long(-((/*static_cast*//*uint32_t*/int)($long2uint(Adjustment.NonVirtual)))));
    }
  } else if (Adjustment.NonVirtual != 0) {
    switch (MD.getAccess()) {
     case AS_none:
      throw new llvm_unreachable("Unsupported access specifier");
     case AS_private:
      Out.$out_char($$G);
      break;
     case AS_protected:
      Out.$out_char($$O);
      break;
     case AS_public:
      Out.$out_char($$W);
    }
    Mangler.mangleNumber($uint2long(-((/*static_cast*//*uint32_t*/int)($long2uint(Adjustment.NonVirtual)))));
  } else {
    switch (MD.getAccess()) {
     case AS_none:
      throw new llvm_unreachable("Unsupported access specifier");
     case AS_private:
      Out.$out_char($$A);
      break;
     case AS_protected:
      Out.$out_char($$I);
      break;
     case AS_public:
      Out.$out_char($$Q);
    }
  }
}

} // END OF class MicrosoftMangleStatics
