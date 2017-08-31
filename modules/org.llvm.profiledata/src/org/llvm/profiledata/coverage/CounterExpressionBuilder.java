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

package org.llvm.profiledata.coverage;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// \brief A Counter expression builder is used to construct the
/// counter expressions. It avoids unnecessary duplication
/// and simplifies algebraic expressions.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 151,
 FQN="llvm::coverage::CounterExpressionBuilder", NM="_ZN4llvm8coverage24CounterExpressionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilderE")
//</editor-fold>
public class CounterExpressionBuilder implements Destructors.ClassWithDestructor {
  /// \brief A list of all the counter expressions
  private std.vector<CounterExpression> Expressions;
  /// \brief A lookup table for the index of a given expression.
  private DenseMapTypeUInt<CounterExpression> ExpressionIndices;
  
  /// \brief Return the counter which corresponds to the given expression.
  ///
  /// If the given expression is already stored in the builder, a counter
  /// that references that expression is returned. Otherwise, the given
  /// expression is added to the builder's collection of expressions.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 33,
   FQN="llvm::coverage::CounterExpressionBuilder::get", NM="_ZN4llvm8coverage24CounterExpressionBuilder3getERKNS0_17CounterExpressionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilder3getERKNS0_17CounterExpressionE")
  //</editor-fold>
  private Counter get(final /*const*/ CounterExpression /*&*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Gather the terms of the expression tree for processing.
  ///
  /// This collects each addition and subtraction referenced by the counter into
  /// a sequence that can be sorted and combined to build a simplified counter
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::extractTerms">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 43,
   FQN="llvm::coverage::CounterExpressionBuilder::extractTerms", NM="_ZN4llvm8coverage24CounterExpressionBuilder12extractTermsENS0_7CounterEiRNS_15SmallVectorImplISt4pairIjiEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilder12extractTermsENS0_7CounterEiRNS_15SmallVectorImplISt4pairIjiEEE")
  //</editor-fold>
  private void extractTerms(Counter C, int Sign, final SmallVectorImpl<std.pairUIntInt> /*&*/ Terms) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Simplifies the given expression tree
  /// by getting rid of algebraically redundant operations.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::simplify">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 60,
   FQN="llvm::coverage::CounterExpressionBuilder::simplify", NM="_ZN4llvm8coverage24CounterExpressionBuilder8simplifyENS0_7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilder8simplifyENS0_7CounterE")
  //</editor-fold>
  private Counter simplify(Counter ExpressionTree) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::getExpressions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 177,
   FQN="llvm::coverage::CounterExpressionBuilder::getExpressions", NM="_ZNK4llvm8coverage24CounterExpressionBuilder14getExpressionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage24CounterExpressionBuilder14getExpressionsEv")
  //</editor-fold>
  public ArrayRef<CounterExpression> getExpressions() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return a counter that represents the expression
  /// that adds LHS and RHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::add">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 114,
   FQN="llvm::coverage::CounterExpressionBuilder::add", NM="_ZN4llvm8coverage24CounterExpressionBuilder3addENS0_7CounterES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilder3addENS0_7CounterES2_")
  //</editor-fold>
  public Counter add(Counter LHS, Counter RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return a counter that represents the expression
  /// that subtracts RHS from LHS.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::subtract">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 118,
   FQN="llvm::coverage::CounterExpressionBuilder::subtract", NM="_ZN4llvm8coverage24CounterExpressionBuilder8subtractENS0_7CounterES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilder8subtractENS0_7CounterES2_")
  //</editor-fold>
  public Counter subtract(Counter LHS, Counter RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::~CounterExpressionBuilder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 151,
   FQN="llvm::coverage::CounterExpressionBuilder::~CounterExpressionBuilder", NM="_ZN4llvm8coverage24CounterExpressionBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterExpressionBuilder::CounterExpressionBuilder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 151,
   FQN="llvm::coverage::CounterExpressionBuilder::CounterExpressionBuilder", NM="_ZN4llvm8coverage24CounterExpressionBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN4llvm8coverage24CounterExpressionBuilderC1Ev")
  //</editor-fold>
  public /*inline*/ CounterExpressionBuilder() {
    // : Expressions(), ExpressionIndices() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Expressions=" + Expressions // NOI18N
              + ", ExpressionIndices=" + ExpressionIndices; // NOI18N
  }
}
