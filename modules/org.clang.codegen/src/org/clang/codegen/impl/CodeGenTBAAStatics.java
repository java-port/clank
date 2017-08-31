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
import org.clang.ast.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenTBAAStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZL15TypeHasMayAliasN5clang8QualTypeE;_ZL16isTBAAPathStructN5clang8QualTypeE; -static-type=CodeGenTBAAStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenTBAAStatics {

//<editor-fold defaultstate="collapsed" desc="TypeHasMayAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 75,
 FQN="TypeHasMayAlias", NM="_ZL15TypeHasMayAliasN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZL15TypeHasMayAliasN5clang8QualTypeE")
//</editor-fold>
public static boolean TypeHasMayAlias(QualType QTy) {
  {
    // Tagged types have declarations, and therefore may have attributes.
    /*const*/ TagType /*P*/ TTy = dyn_cast_TagType(QTy);
    if ((TTy != null)) {
      return TTy.getDecl().hasAttr(MayAliasAttr.class);
    }
  }
  {
    
    // Typedef types have declarations, and therefore may have attributes.
    /*const*/ TypedefType /*P*/ TTy = dyn_cast_TypedefType(QTy);
    if ((TTy != null)) {
      if (TTy.getDecl().hasAttr(MayAliasAttr.class)) {
        return true;
      }
      // Also, their underlying types may have relevant attributes.
      return TypeHasMayAlias(TTy.desugar());
    }
  }
  
  return false;
}


/// Check if the given type can be handled by path-aware TBAA.
//<editor-fold defaultstate="collapsed" desc="isTBAAPathStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 231,
 FQN="isTBAAPathStruct", NM="_ZL16isTBAAPathStructN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZL16isTBAAPathStructN5clang8QualTypeE")
//</editor-fold>
public static boolean isTBAAPathStruct(QualType QTy) {
  {
    /*const*/ RecordType /*P*/ TTy = QTy.$arrow().getAs$RecordType();
    if ((TTy != null)) {
      /*const*/ RecordDecl /*P*/ RD = TTy.getDecl().getDefinition();
      if (RD.hasFlexibleArrayMember()) {
        return false;
      }
      // RD can be struct, union, class, interface or enum.
      // For now, we only handle struct and class.
      if (RD.isStruct() || RD.isClass()) {
        return true;
      }
    }
  }
  return false;
}

} // END OF class CodeGenTBAAStatics
