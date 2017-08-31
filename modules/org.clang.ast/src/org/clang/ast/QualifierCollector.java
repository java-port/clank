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


/// A qualifier set is used to build a set of qualifiers.
//<editor-fold defaultstate="collapsed" desc="clang::QualifierCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5225,
 FQN="clang::QualifierCollector", NM="_ZN5clang18QualifierCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18QualifierCollectorE")
//</editor-fold>
public class QualifierCollector extends /*public*/ Qualifiers {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierCollector::QualifierCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5227,
   FQN="clang::QualifierCollector::QualifierCollector", NM="_ZN5clang18QualifierCollectorC1ENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18QualifierCollectorC1ENS_10QualifiersE")
  //</editor-fold>
  public QualifierCollector() {
    this(new Qualifiers());
  }
  public QualifierCollector(Qualifiers Qs/*= Qualifiers()*/) {
    // : Qualifiers(Qs) 
    //START JInit
    super(Qs);
    //END JInit
  }

  
  /// Collect any qualifiers on the given type and return an
  /// unqualified type.  The qualifiers are assumed to be consistent
  /// with those already in the type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierCollector::strip">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5232,
   FQN="clang::QualifierCollector::strip", NM="_ZN5clang18QualifierCollector5stripENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang18QualifierCollector5stripENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ Type /*P*/ strip(QualType type) {
    addFastQualifiers(type.getLocalFastQualifiers());
    if (!type.hasLocalNonFastQualifiers()) {
      return type.getTypePtrUnsafe();
    }
    
    /*const*/ ExtQuals /*P*/ extQuals = type.getExtQualsUnsafe();
    addConsistentQualifiers(extQuals.getQualifiers());
    return extQuals.getBaseType();
  }

  
  /// Apply the collected qualifiers to the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierCollector::apply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3178,
   FQN="clang::QualifierCollector::apply", NM="_ZNK5clang18QualifierCollector5applyERKNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18QualifierCollector5applyERKNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public QualType apply(final /*const*/ ASTContext /*&*/ Context, QualType QT) /*const*/ {
    if (!hasNonFastQualifiers()) {
      return QT.withFastQualifiers(getFastQualifiers());
    }
    
    return Context.getQualifiedType(new QualType(QT), new Qualifiers(/*Deref*/this));
  }

  
  /// Apply the collected qualifiers to the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifierCollector::apply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3186,
   FQN="clang::QualifierCollector::apply", NM="_ZNK5clang18QualifierCollector5applyERKNS_10ASTContextEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang18QualifierCollector5applyERKNS_10ASTContextEPKNS_4TypeE")
  //</editor-fold>
  public QualType apply(final /*const*/ ASTContext /*&*/ Context, /*const*/ Type /*P*/ T) /*const*/ {
    if (!hasNonFastQualifiers()) {
      return new QualType(T, getFastQualifiers());
    }
    
    return Context.getQualifiedType(T, new Qualifiers(/*Deref*/this));
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
