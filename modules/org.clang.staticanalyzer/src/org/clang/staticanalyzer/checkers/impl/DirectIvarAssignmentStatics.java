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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type DirectIvarAssignmentStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZL10AttrFilterPKN5clang14ObjCMethodDeclE;_ZN12_GLOBAL__N_1L19DefaultMethodFilterEPKN5clang14ObjCMethodDeclE;_ZN12_GLOBAL__N_1L23findPropertyBackingIvarEPKN5clang16ObjCPropertyDeclEPKNS0_17ObjCInterfaceDeclERNS0_10ASTContextE;_ZN12_GLOBAL__N_1L34isAnnotatedToAllowDirectAssignmentEPKN5clang4DeclE; -static-type=DirectIvarAssignmentStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class DirectIvarAssignmentStatics {


/// The default method filter, which is used to filter out the methods on which
/// the check should not be performed.
///
/// Checks for the init, dealloc, and any other functions that might be allowed
/// to perform direct instance variable assignment based on their name.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DefaultMethodFilter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 43,
 FQN="(anonymous namespace)::DefaultMethodFilter", NM="_ZN12_GLOBAL__N_1L19DefaultMethodFilterEPKN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_1L19DefaultMethodFilterEPKN5clang14ObjCMethodDeclE")
//</editor-fold>
public static boolean DefaultMethodFilter(/*const*/ ObjCMethodDecl /*P*/ M) {
  return M.getMethodFamily() == ObjCMethodFamily.OMF_init
     || M.getMethodFamily() == ObjCMethodFamily.OMF_dealloc
     || M.getMethodFamily() == ObjCMethodFamily.OMF_copy
     || M.getMethodFamily() == ObjCMethodFamily.OMF_mutableCopy
     || M.getSelector().getNameForSlot(0).find(/*STRINGREF_STR*/"init") != StringRef.npos
     || M.getSelector().getNameForSlot(0).find(/*STRINGREF_STR*/"Init") != StringRef.npos;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::findPropertyBackingIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 95,
 FQN="(anonymous namespace)::findPropertyBackingIvar", NM="_ZN12_GLOBAL__N_1L23findPropertyBackingIvarEPKN5clang16ObjCPropertyDeclEPKNS0_17ObjCInterfaceDeclERNS0_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_1L23findPropertyBackingIvarEPKN5clang16ObjCPropertyDeclEPKNS0_17ObjCInterfaceDeclERNS0_10ASTContextE")
//</editor-fold>
public static /*const*/ ObjCIvarDecl /*P*/ findPropertyBackingIvar(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                       /*const*/ ObjCInterfaceDecl /*P*/ InterD, 
                       final ASTContext /*&*/ Ctx) {
  // Check for synthesized ivars.
  ObjCIvarDecl /*P*/ ID = PD.getPropertyIvarDecl();
  if ((ID != null)) {
    return ID;
  }
  
  ObjCInterfaceDecl /*P*/ NonConstInterD = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(InterD));
  
  // Check for existing "_PropName".
  ID = NonConstInterD.lookupInstanceVariable(PD.getDefaultSynthIvarName(Ctx));
  if ((ID != null)) {
    return ID;
  }
  
  // Check for existing "PropName".
  IdentifierInfo /*P*/ PropIdent = PD.getIdentifier();
  ID = NonConstInterD.lookupInstanceVariable(PropIdent);
  
  return ID;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isAnnotatedToAllowDirectAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 156,
 FQN="(anonymous namespace)::isAnnotatedToAllowDirectAssignment", NM="_ZN12_GLOBAL__N_1L34isAnnotatedToAllowDirectAssignmentEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_1L34isAnnotatedToAllowDirectAssignmentEPKN5clang4DeclE")
//</editor-fold>
public static boolean isAnnotatedToAllowDirectAssignment(/*const*/ Decl /*P*/ D) {
  for (/*const*/ AnnotateAttr /*P*/ Ann : D.specific_attrs(AnnotateAttr.class))  {
    if ($eq_StringRef(Ann.getAnnotation(), 
        /*STRINGREF_STR*/"objc_allow_direct_instance_variable_assignment")) {
      return true;
    }
  }
  return false;
}


// Register the checker that checks for direct accesses in functions annotated
// with __attribute__((annotate("objc_no_direct_instance_variable_assignment"))).
//<editor-fold defaultstate="collapsed" desc="AttrFilter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 217,
 FQN="AttrFilter", NM="_ZL10AttrFilterPKN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZL10AttrFilterPKN5clang14ObjCMethodDeclE")
//</editor-fold>
public static boolean AttrFilter(/*const*/ ObjCMethodDecl /*P*/ M) {
  for (/*const*/ AnnotateAttr /*P*/ Ann : M.specific_attrs(AnnotateAttr.class))  {
    if ($eq_StringRef(Ann.getAnnotation(), /*STRINGREF_STR*/"objc_no_direct_instance_variable_assignment")) {
      return false;
    }
  }
  return true;
}

} // END OF class DirectIvarAssignmentStatics
