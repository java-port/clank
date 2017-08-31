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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type DeclObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZL24CollectOverriddenMethodsPKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EE;_ZL25isIntroducingInitializersPKN5clang17ObjCInterfaceDeclE;_ZL28collectOverriddenMethodsSlowPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIS2_EE;_ZL31CollectOverriddenMethodsRecursePKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EEb;_ZN12_GLOBAL__N_1ltERKNS_19SynthesizeIvarChunkES2_; -static-type=DeclObjCStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclObjCStatics {

//<editor-fold defaultstate="collapsed" desc="isIntroducingInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 465,
 FQN="isIntroducingInitializers", NM="_ZL25isIntroducingInitializersPKN5clang17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZL25isIntroducingInitializersPKN5clang17ObjCInterfaceDeclE")
//</editor-fold>
public static boolean isIntroducingInitializers(/*const*/ ObjCInterfaceDecl /*P*/ D) {
  for (/*const*/ ObjCMethodDecl /*P*/ MD : D.instance_methods()) {
    if (MD.getMethodFamily() == ObjCMethodFamily.OMF_init && !MD.isOverriding()) {
      return true;
    }
  }
  for (/*const*/ ObjCCategoryDecl /*P*/ Ext : D.visible_extensions()) {
    for (/*const*/ ObjCMethodDecl /*P*/ MD : Ext.instance_methods()) {
      if (MD.getMethodFamily() == ObjCMethodFamily.OMF_init && !MD.isOverriding()) {
        return true;
      }
    }
  }
  {
    /*const*/ ObjCImplementationDecl /*P*/ ImplD = D.getImplementation();
    if ((ImplD != null)) {
      for (/*const*/ ObjCMethodDecl /*P*/ MD : ImplD.instance_methods()) {
        if (MD.getMethodFamily() == ObjCMethodFamily.OMF_init && !MD.isOverriding()) {
          return true;
        }
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CollectOverriddenMethodsRecurse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1104,
 FQN="CollectOverriddenMethodsRecurse", NM="_ZL31CollectOverriddenMethodsRecursePKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZL31CollectOverriddenMethodsRecursePKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EEb")
//</editor-fold>
public static void CollectOverriddenMethodsRecurse(/*const*/ ObjCContainerDecl /*P*/ Container, 
                               /*const*/ ObjCMethodDecl /*P*/ Method, 
                               final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ Methods, 
                               boolean MovedToSuper) {
  if (!(Container != null)) {
    return;
  }
  {
    
    // In categories look for overriden methods from protocols. A method from
    // category is not "overriden" since it is considered as the "same" method
    // (same USR) as the one from the interface.
    /*const*/ ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Container);
    if ((Category != null)) {
      // Check whether we have a matching method at this category but only if we
      // are at the super class level.
      if (MovedToSuper) {
        {
          ObjCMethodDecl /*P*/ Overridden = Container.getMethod(Method.getSelector(), 
              Method.isInstanceMethod(), 
              /*AllowHidden=*/ true);
          if ((Overridden != null)) {
            if (Method != Overridden) {
              // We found an override at this category; there is no need to look
              // into its protocols.
              Methods.push_back(Overridden);
              return;
            }
          }
        }
      }
      
      for (/*const*/ ObjCProtocolDecl /*P*/ P : Category.protocols())  {
        CollectOverriddenMethodsRecurse(P, Method, Methods, MovedToSuper);
      }
      return;
    }
  }
  {
    
    // Check whether we have a matching method at this level.
    /*const*/ ObjCMethodDecl /*P*/ Overridden = Container.getMethod(Method.getSelector(), 
        Method.isInstanceMethod(), 
        /*AllowHidden=*/ true);
    if ((Overridden != null)) {
      if (Method != Overridden) {
        // We found an override at this level; there is no need to look
        // into other protocols or categories.
        Methods.push_back(Overridden);
        return;
      }
    }
  }
  {
    
    /*const*/ ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Container);
    if ((Protocol != null)) {
      for (/*const*/ ObjCProtocolDecl /*P*/ P : Protocol.protocols())  {
        CollectOverriddenMethodsRecurse(P, Method, Methods, MovedToSuper);
      }
    }
  }
  {
    
    /*const*/ ObjCInterfaceDecl /*P*/ Interface = dyn_cast_ObjCInterfaceDecl(Container);
    if ((Interface != null)) {
      for (/*const*/ ObjCProtocolDecl /*P*/ P : Interface.protocols())  {
        CollectOverriddenMethodsRecurse(P, Method, Methods, MovedToSuper);
      }
      
      for (/*const*/ ObjCCategoryDecl /*P*/ Cat : Interface.known_categories())  {
        CollectOverriddenMethodsRecurse(Cat, Method, Methods, MovedToSuper);
      }
      {
        
        /*const*/ ObjCInterfaceDecl /*P*/ Super = Interface.getSuperClass();
        if ((Super != null)) {
          CollectOverriddenMethodsRecurse(Super, Method, Methods, 
              /*MovedToSuper=*/ true);
          /*JAVA:return*/return;
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="CollectOverriddenMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1166,
 FQN="CollectOverriddenMethods", NM="_ZL24CollectOverriddenMethodsPKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZL24CollectOverriddenMethodsPKN5clang17ObjCContainerDeclEPKNS_14ObjCMethodDeclERN4llvm15SmallVectorImplIS5_EE")
//</editor-fold>
public static /*inline*/ void CollectOverriddenMethods(/*const*/ ObjCContainerDecl /*P*/ Container, 
                        /*const*/ ObjCMethodDecl /*P*/ Method, 
                        final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ Methods) {
  CollectOverriddenMethodsRecurse(Container, Method, Methods, 
      /*MovedToSuper=*/ false);
}

//<editor-fold defaultstate="collapsed" desc="collectOverriddenMethodsSlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1173,
 FQN="collectOverriddenMethodsSlow", NM="_ZL28collectOverriddenMethodsSlowPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZL28collectOverriddenMethodsSlowPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIS2_EE")
//</editor-fold>
public static void collectOverriddenMethodsSlow(/*const*/ ObjCMethodDecl /*P*/ Method, 
                            final SmallVectorImpl</*const*/ ObjCMethodDecl /*P*/ > /*&*/ overridden) {
  assert (Method.isOverriding());
  {
    
    /*const*/ ObjCProtocolDecl /*P*/ ProtD = dyn_cast_ObjCProtocolDecl(Method.getDeclContext$Const());
    if ((ProtD != null)) {
      CollectOverriddenMethods(ProtD, Method, overridden);
    } else {
      /*const*/ ObjCImplDecl /*P*/ IMD = dyn_cast_ObjCImplDecl(Method.getDeclContext$Const());
      if ((IMD != null)) {
        /*const*/ ObjCInterfaceDecl /*P*/ ID = IMD.getClassInterface$Const();
        if (!(ID != null)) {
          return;
        }
        {
          // Start searching for overridden methods using the method from the
          // interface as starting point.
          /*const*/ ObjCMethodDecl /*P*/ IFaceMeth = ID.getMethod(Method.getSelector(), 
              Method.isInstanceMethod(), 
              /*AllowHidden=*/ true);
          if ((IFaceMeth != null)) {
            Method = IFaceMeth;
          }
        }
        CollectOverriddenMethods(ID, Method, overridden);
      } else {
        /*const*/ ObjCCategoryDecl /*P*/ CatD = dyn_cast_ObjCCategoryDecl(Method.getDeclContext$Const());
        if ((CatD != null)) {
          /*const*/ ObjCInterfaceDecl /*P*/ ID = CatD.getClassInterface$Const();
          if (!(ID != null)) {
            return;
          }
          {
            // Start searching for overridden methods using the method from the
            // interface as starting point.
            /*const*/ ObjCMethodDecl /*P*/ IFaceMeth = ID.getMethod(Method.getSelector(), 
                Method.isInstanceMethod(), 
                /*AllowHidden=*/ true);
            if ((IFaceMeth != null)) {
              Method = IFaceMeth;
            }
          }
          CollectOverriddenMethods(ID, Method, overridden);
        } else {
          CollectOverriddenMethods(dyn_cast_or_null_ObjCContainerDecl(Method.getDeclContext$Const()), 
              Method, overridden);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1506,
 FQN="(anonymous namespace)::operator<", NM="_ZN12_GLOBAL__N_1ltERKNS_19SynthesizeIvarChunkES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN12_GLOBAL__N_1ltERKNS_19SynthesizeIvarChunkES2_")
//</editor-fold>
public static boolean $less_SynthesizeIvarChunk$C(final /*const*/ SynthesizeIvarChunk /*&*/ LHS, 
                           final /*const*/ SynthesizeIvarChunk /*&*/ RHS) {
  return $less_ulong(LHS.Size, RHS.Size);
}

} // END OF class DeclObjCStatics
