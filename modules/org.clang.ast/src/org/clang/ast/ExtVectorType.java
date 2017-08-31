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

package org.clang.ast;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;


/// ExtVectorType - Extended vector type. This type is created using
/// __attribute__((ext_vector_type(n)), where "n" is the number of elements.
/// Unlike vector_size, ext_vector_type is only allowed on typedef's. This
/// class enables syntactic extensions, like Vector Components for accessing
/// points, colors, and textures (modeled after OpenGL Shading Language).
//<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2816,
 FQN="clang::ExtVectorType", NM="_ZN5clang13ExtVectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorTypeE")
//</editor-fold>
public class ExtVectorType extends /*public*/ VectorType {
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::ExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2817,
   FQN="clang::ExtVectorType::ExtVectorType", NM="_ZN5clang13ExtVectorTypeC1ENS_8QualTypeEjS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorTypeC1ENS_8QualTypeEjS1_")
  //</editor-fold>
  /*friend*//*package*/ ExtVectorType(QualType vecType, /*uint*/int nElements, QualType canonType) {
    // : VectorType(ExtVector, vecType, nElements, canonType, GenericVector) 
    //START JInit
    super(TypeClass.ExtVector, new QualType(vecType), nElements, new QualType(canonType), VectorKind.GenericVector);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::getPointAccessorIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2821,
   FQN="clang::ExtVectorType::getPointAccessorIdx", NM="_ZN5clang13ExtVectorType19getPointAccessorIdxEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorType19getPointAccessorIdxEc")
  //</editor-fold>
  public static int getPointAccessorIdx(/*char*/byte c) {
    switch (c) {
     default:
      return -1;
     case 'x':
      return 0;
     case 'y':
      return 1;
     case 'z':
      return 2;
     case 'w':
      return 3;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::getNumericAccessorIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2830,
   FQN="clang::ExtVectorType::getNumericAccessorIdx", NM="_ZN5clang13ExtVectorType21getNumericAccessorIdxEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorType21getNumericAccessorIdxEc")
  //</editor-fold>
  public static int getNumericAccessorIdx(/*char*/byte c) {
    switch (c) {
     default:
      return -1;
     case '0':
      return 0;
     case '1':
      return 1;
     case '2':
      return 2;
     case '3':
      return 3;
     case '4':
      return 4;
     case '5':
      return 5;
     case '6':
      return 6;
     case '7':
      return 7;
     case '8':
      return 8;
     case '9':
      return 9;
     case 'A':
     case 'a':
      return 10;
     case 'B':
     case 'b':
      return 11;
     case 'C':
     case 'c':
      return 12;
     case 'D':
     case 'd':
      return 13;
     case 'E':
     case 'e':
      return 14;
     case 'F':
     case 'f':
      return 15;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::getAccessorIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2858,
   FQN="clang::ExtVectorType::getAccessorIdx", NM="_ZN5clang13ExtVectorType14getAccessorIdxEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorType14getAccessorIdxEc")
  //</editor-fold>
  public static int getAccessorIdx(/*char*/byte c) {
    {
      int idx = getPointAccessorIdx(c) + 1;
      if ((idx != 0)) {
        return idx - 1;
      }
    }
    return getNumericAccessorIdx(c);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::isAccessorWithinNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2863,
   FQN="clang::ExtVectorType::isAccessorWithinNumElements", NM="_ZNK5clang13ExtVectorType27isAccessorWithinNumElementsEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ExtVectorType27isAccessorWithinNumElementsEc")
  //</editor-fold>
  public boolean isAccessorWithinNumElements(/*char*/byte c) /*const*/ {
    {
      int idx = getAccessorIdx(c) + 1;
      if ((idx != 0)) {
        return $less_uint(((/*uint*/int)(idx - 1)), getNumElements());
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2868,
   FQN="clang::ExtVectorType::isSugared", NM="_ZNK5clang13ExtVectorType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ExtVectorType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2869,
   FQN="clang::ExtVectorType::desugar", NM="_ZNK5clang13ExtVectorType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ExtVectorType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtVectorType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2871,
   FQN="clang::ExtVectorType::classof", NM="_ZN5clang13ExtVectorType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ExtVectorType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ExtVector;
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
