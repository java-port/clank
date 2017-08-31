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
import org.llvm.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type DeclPrinterStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZL11GetBaseTypeN5clang8QualTypeE;_ZL11getDeclTypePN5clang4DeclE; -static-type=DeclPrinterStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclPrinterStatics {

//<editor-fold defaultstate="collapsed" desc="GetBaseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 117,
 FQN="GetBaseType", NM="_ZL11GetBaseTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZL11GetBaseTypeN5clang8QualTypeE")
//</editor-fold>
public static QualType GetBaseType(QualType T) {
  // FIXME: This should be on the Type class!
  QualType BaseType = new QualType(T);
  while (!BaseType.$arrow().isSpecifierType()) {
    if (isa_TypedefType(BaseType)) {
      break;
    } else {
      /*const*/ PointerType /*P*/ PTy = BaseType.$arrow().getAs(PointerType.class);
      if ((PTy != null)) {
        BaseType.$assignMove(PTy.getPointeeType());
      } else {
        /*const*/ BlockPointerType /*P*/ BPy = BaseType.$arrow().getAs(BlockPointerType.class);
        if ((BPy != null)) {
          BaseType.$assignMove(BPy.getPointeeType());
        } else {
          /*const*/ ArrayType /*P*/ ATy = dyn_cast_ArrayType(BaseType);
          if ((ATy != null)) {
            BaseType.$assignMove(ATy.getElementType());
          } else {
            /*const*/ FunctionType /*P*/ FTy = BaseType.$arrow().getAs(FunctionType.class);
            if ((FTy != null)) {
              BaseType.$assignMove(FTy.getReturnType());
            } else {
              /*const*/ VectorType /*P*/ VTy = BaseType.$arrow().getAs(VectorType.class);
              if ((VTy != null)) {
                BaseType.$assignMove(VTy.getElementType());
              } else {
                /*const*/ ReferenceType /*P*/ RTy = BaseType.$arrow().getAs(ReferenceType.class);
                if ((RTy != null)) {
                  BaseType.$assignMove(RTy.getPointeeType());
                } else {
                  /*const*/ AutoType /*P*/ ATy$1 = BaseType.$arrow().getAs(AutoType.class);
                  if ((ATy$1 != null)) {
                    BaseType.$assignMove(ATy$1.getDeducedType());
                  } else {
                    throw new llvm_unreachable("Unknown declarator!");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return BaseType;
}

//<editor-fold defaultstate="collapsed" desc="getDeclType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp", line = 143,
 FQN="getDeclType", NM="_ZL11getDeclTypePN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclPrinter.cpp -nm=_ZL11getDeclTypePN5clang4DeclE")
//</editor-fold>
public static QualType getDeclType(Decl /*P*/ D) {
  {
    TypedefNameDecl /*P*/ TDD = dyn_cast_TypedefNameDecl(D);
    if ((TDD != null)) {
      return TDD.getUnderlyingType();
    }
  }
  {
    ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
    if ((VD != null)) {
      return VD.getType();
    }
  }
  return new QualType();
}

} // END OF class DeclPrinterStatics
