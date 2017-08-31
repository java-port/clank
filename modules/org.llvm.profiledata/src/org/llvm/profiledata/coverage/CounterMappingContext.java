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


/// \brief A Counter mapping context is used to connect the counters,
/// expressions and the obtained counter values.
//<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 275,
 FQN="llvm::coverage::CounterMappingContext", NM="_ZN4llvm8coverage21CounterMappingContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage21CounterMappingContextE")
//</editor-fold>
public class CounterMappingContext {
  private ArrayRef<CounterExpression> Expressions;
  private ArrayRefULong CounterValues;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext::CounterMappingContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 280,
   FQN="llvm::coverage::CounterMappingContext::CounterMappingContext", NM="_ZN4llvm8coverage21CounterMappingContextC1ENS_8ArrayRefINS0_17CounterExpressionEEENS2_IyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage21CounterMappingContextC1ENS_8ArrayRefINS0_17CounterExpressionEEENS2_IyEE")
  //</editor-fold>
  public CounterMappingContext(ArrayRef<CounterExpression> Expressions) {
    this(Expressions, 
      new ArrayRefULong(None));
  }
  public CounterMappingContext(ArrayRef<CounterExpression> Expressions, 
      ArrayRefULong CounterValues/*= None*/) {
    // : Expressions(Expressions), CounterValues(CounterValues) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext::setCounts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 284,
   FQN="llvm::coverage::CounterMappingContext::setCounts", NM="_ZN4llvm8coverage21CounterMappingContext9setCountsENS_8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZN4llvm8coverage21CounterMappingContext9setCountsENS_8ArrayRefIyEE")
  //</editor-fold>
  public void setCounts(ArrayRefULong Counts) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 123,
   FQN="llvm::coverage::CounterMappingContext::dump", NM="_ZNK4llvm8coverage21CounterMappingContext4dumpERKNS0_7CounterERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage21CounterMappingContext4dumpERKNS0_7CounterERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final /*const*/ Counter /*&*/ C, 
      final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/Coverage/CoverageMapping.h", line = 287,
   FQN="llvm::coverage::CounterMappingContext::dump", NM="_ZNK4llvm8coverage21CounterMappingContext4dumpERKNS0_7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage21CounterMappingContext4dumpERKNS0_7CounterE")
  //</editor-fold>
  public void dump(final /*const*/ Counter /*&*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return the number of times that a region of code associated with
  /// this counter was executed.
  //<editor-fold defaultstate="collapsed" desc="llvm::coverage::CounterMappingContext::evaluate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp", line = 154,
   FQN="llvm::coverage::CounterMappingContext::evaluate", NM="_ZNK4llvm8coverage21CounterMappingContext8evaluateERKNS0_7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMapping.cpp -nm=_ZNK4llvm8coverage21CounterMappingContext8evaluateERKNS0_7CounterE")
  //</editor-fold>
  public Expected<Long/*int64_t*/> evaluate(final /*const*/ Counter /*&*/ C) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Expressions=" + Expressions // NOI18N
              + ", CounterValues=" + CounterValues; // NOI18N
  }
}
