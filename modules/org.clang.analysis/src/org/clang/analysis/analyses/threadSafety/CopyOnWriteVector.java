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

package org.clang.analysis.analyses.threadSafety;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.analysis.analyses.threadSafety.*;

// end namespace til

// A copy on write vector.
// The vector can be in one of three states:
// * invalid -- no operations are permitted.
// * read-only -- read operations are permitted.
// * writable -- read and write operations are permitted.
// The init(), destroy(), and makeWritable() methods will change state.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 227,
 FQN="clang::threadSafety::CopyOnWriteVector", NM="_ZN5clang12threadSafety17CopyOnWriteVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorE")
//</editor-fold>
public class CopyOnWriteVector</*typename*/ T>  implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::VectorData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 229,
   FQN="clang::threadSafety::CopyOnWriteVector::VectorData", NM="_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataE")
  //</editor-fold>
  private /*static*/ class VectorData {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::VectorData::VectorData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 231,
     FQN="clang::threadSafety::CopyOnWriteVector::VectorData::VectorData", NM="_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataC1Ev")
    //</editor-fold>
    public VectorData() {
      // : NumRefs(1) 
      //START JInit
      this.NumRefs = 1;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::VectorData::VectorData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 232,
     FQN="clang::threadSafety::CopyOnWriteVector::VectorData::VectorData", NM="_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector10VectorDataC1ERKS2_")
    //</editor-fold>
    public VectorData(final /*const*/ VectorData /*&*/ VD) {
      // : NumRefs(1), Vect(VD.Vect) 
      //START JInit
      this.NumRefs = 1;
      this.Vect = /*ParenListExpr*/new std.vector<T>(VD.Vect);
      //END JInit
    }

    
    public /*uint*/int NumRefs;
    public std.vector<T> Vect;
    
    @Override public String toString() {
      return "" + "NumRefs=" + NumRefs // NOI18N
                + ", Vect=" + Vect; // NOI18N
    }
  };
  
  // No copy constructor or copy assignment.  Use clone() with move assignment.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 239,
   FQN="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>", NM="_ZN5clang12threadSafety17CopyOnWriteVectorC1ERKNS0_17CopyOnWriteVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorC1ERKNS0_17CopyOnWriteVectorIT_EE")
  //</editor-fold>
  private CopyOnWriteVector(final /*const*/ CopyOnWriteVector<T> /*&*/ V) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 240,
   FQN="clang::threadSafety::CopyOnWriteVector::operator=", NM="_ZN5clang12threadSafety17CopyOnWriteVectoraSERKNS0_17CopyOnWriteVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectoraSERKNS0_17CopyOnWriteVectorIT_EE")
  //</editor-fold>
  private void $assign(final /*const*/ CopyOnWriteVector<T> /*&*/ V) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 243,
   FQN="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>", NM="_ZN5clang12threadSafety17CopyOnWriteVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorC1Ev")
  //</editor-fold>
  public CopyOnWriteVector() {
    // : Data(null) 
    //START JInit
    this.Data = /*ParenListExpr*/null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 244,
   FQN="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>", NM="_ZN5clang12threadSafety17CopyOnWriteVectorC1EONS0_17CopyOnWriteVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorC1EONS0_17CopyOnWriteVectorIT_EE")
  //</editor-fold>
  public CopyOnWriteVector(JD$Move _dparam, final CopyOnWriteVector<T> /*&&*/V) {
    // : Data(V.Data) 
    //START JInit
    this.Data = /*ParenListExpr*/V.Data;
    //END JInit
    V.Data = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::~CopyOnWriteVector<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 245,
   FQN="clang::threadSafety::CopyOnWriteVector::~CopyOnWriteVector<T>", NM="_ZN5clang12threadSafety17CopyOnWriteVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    destroy();
  }

  
  // Returns true if this holds a valid vector.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::valid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 248,
   FQN="clang::threadSafety::CopyOnWriteVector::valid", NM="_ZNK5clang12threadSafety17CopyOnWriteVector5validEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector5validEv")
  //</editor-fold>
  public boolean valid() /*const*/ {
    return Data != null;
  }

  
  // Returns true if this vector is writable.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::writable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 251,
   FQN="clang::threadSafety::CopyOnWriteVector::writable", NM="_ZNK5clang12threadSafety17CopyOnWriteVector8writableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector8writableEv")
  //</editor-fold>
  public boolean writable() /*const*/ {
    return Native.$bool(Data) && Native.$bool(Native.$eq(Data.NumRefs, 1));
  }

  
  // If this vector is not valid, initialize it to a valid vector.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::init">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 254,
   FQN="clang::threadSafety::CopyOnWriteVector::init", NM="_ZN5clang12threadSafety17CopyOnWriteVector4initEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector4initEv")
  //</editor-fold>
  public void init() {
    if (Native.$not(Data)) {
      Data = new VectorData();
    }
  }

  
  // Destroy this vector; thus making it invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 261,
   FQN="clang::threadSafety::CopyOnWriteVector::destroy", NM="_ZN5clang12threadSafety17CopyOnWriteVector7destroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector7destroyEv")
  //</editor-fold>
  public void destroy() {
    if (Native.$not(Data)) {
      return;
    }
    if (Native.$lesseq(Data.NumRefs, 1)) {
      /*delete*/Destructors.$destroy(Data);
    } else {
      --Data.NumRefs;
    }
    Data = null;
  }

  
  // Make this vector writable, creating a copy if needed.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::makeWritable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 272,
   FQN="clang::threadSafety::CopyOnWriteVector::makeWritable", NM="_ZN5clang12threadSafety17CopyOnWriteVector12makeWritableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector12makeWritableEv")
  //</editor-fold>
  public void makeWritable() {
    if (Native.$not(Data)) {
      Data = new VectorData();
      return;
    }
    if (Native.$eq(Data.NumRefs, 1)) {
      return; // already writeable.
    }
    --Data.NumRefs;
    Data = new VectorData(Native.$star(Data));
  }

  
  // Create a lazy copy of this vector.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::clone">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 284,
   FQN="clang::threadSafety::CopyOnWriteVector::clone", NM="_ZN5clang12threadSafety17CopyOnWriteVector5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector5cloneEv")
  //</editor-fold>
  public CopyOnWriteVector<T> clone() {
    return new CopyOnWriteVector<T>(Data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 286,
   FQN="clang::threadSafety::CopyOnWriteVector::operator=", NM="_ZN5clang12threadSafety17CopyOnWriteVectoraSEONS0_17CopyOnWriteVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectoraSEONS0_17CopyOnWriteVectorIT_EE")
  //</editor-fold>
  public CopyOnWriteVector<T> /*&*/ $assignMove(final CopyOnWriteVector<T> /*&&*/V) {
    destroy();
    Data = V.Data;
    V.Data = null;
    return Native.$star(this);
  }

  
  /*typedef typename std::vector<T>::const_iterator const_iterator*/
//  public final class const_iterator extends std.vector.iterator<T>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::elements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 295,
   FQN="clang::threadSafety::CopyOnWriteVector::elements", NM="_ZNK5clang12threadSafety17CopyOnWriteVector8elementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector8elementsEv")
  //</editor-fold>
  public /*const*/ std.vector<T> /*&*/ elements() /*const*/ {
    return Data.Vect;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 297,
   FQN="clang::threadSafety::CopyOnWriteVector::begin", NM="_ZNK5clang12threadSafety17CopyOnWriteVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector5beginEv")
  //</editor-fold>
  public std.vector.iterator<T> begin() /*const*/ {
    return elements().cbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 298,
   FQN="clang::threadSafety::CopyOnWriteVector::end", NM="_ZNK5clang12threadSafety17CopyOnWriteVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector3endEv")
  //</editor-fold>
  public std.vector.iterator<T> end() /*const*/ {
    return elements().cend();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 300,
   FQN="clang::threadSafety::CopyOnWriteVector::operator[]", NM="_ZNK5clang12threadSafety17CopyOnWriteVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVectorixEj")
  //</editor-fold>
  public /*const*/ T /*&*/ $at(/*uint*/int i) /*const*/ {
    return elements().$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 302,
   FQN="clang::threadSafety::CopyOnWriteVector::size", NM="_ZNK5clang12threadSafety17CopyOnWriteVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Data != null ? elements().size() : 0;
  }

  
  // Return true if V and this vector refer to the same data.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::sameAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 305,
   FQN="clang::threadSafety::CopyOnWriteVector::sameAs", NM="_ZNK5clang12threadSafety17CopyOnWriteVector6sameAsERKNS0_17CopyOnWriteVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety17CopyOnWriteVector6sameAsERKNS0_17CopyOnWriteVectorIT_EE")
  //</editor-fold>
  public boolean sameAs(final /*const*/ CopyOnWriteVector<T> /*&*/ V) /*const*/ {
    return Native.$eq(Data, V.Data);
  }

  
  // Clear vector.  The vector must be writable.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 308,
   FQN="clang::threadSafety::CopyOnWriteVector::clear", NM="_ZN5clang12threadSafety17CopyOnWriteVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector5clearEv")
  //</editor-fold>
  public void clear() {
    assert Native.$bool(writable()) : "Vector is not writable!";
    Data.Vect.clear();
  }

  
  // Push a new element onto the end.  The vector must be writable.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::push_back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 314,
   FQN="clang::threadSafety::CopyOnWriteVector::push_back", NM="_ZN5clang12threadSafety17CopyOnWriteVector9push_backERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector9push_backERKT_")
  //</editor-fold>
  public void push_back(final /*const*/ T /*&*/ Elem) {
    assert Native.$bool(writable()) : "Vector is not writable!";
    Data.Vect.push_back(Elem);
  }

  
  // Gets a mutable reference to the element at index(i).
  // The vector must be writable.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::elem">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 321,
   FQN="clang::threadSafety::CopyOnWriteVector::elem", NM="_ZN5clang12threadSafety17CopyOnWriteVector4elemEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector4elemEj")
  //</editor-fold>
  public T /*&*/ elem(/*uint*/int i) {
    assert Native.$bool(writable()) : "Vector is not writable!";
    return Data.Vect.$at(i);
  }

  
  // Drops elements from the back until the vector has size i.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::downsize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 327,
   FQN="clang::threadSafety::CopyOnWriteVector::downsize", NM="_ZN5clang12threadSafety17CopyOnWriteVector8downsizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVector8downsizeEj")
  //</editor-fold>
  public void downsize(/*uint*/int i) {
    assert Native.$bool(writable()) : "Vector is not writable!";
    Data.Vect.erase(Data.Vect.begin().$add(i), Data.Vect.end());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 333,
   FQN="clang::threadSafety::CopyOnWriteVector::CopyOnWriteVector<T>", NM="_ZN5clang12threadSafety17CopyOnWriteVectorC1EPNS1_10VectorDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety17CopyOnWriteVectorC1EPNS1_10VectorDataE")
  //</editor-fold>
  private CopyOnWriteVector(VectorData /*P*/ D) {
    // : Data(D) 
    //START JInit
    this.Data = /*ParenListExpr*/D;
    //END JInit
    if (Native.$not(Data)) {
      return;
    }
    ++Data.NumRefs;
  }

  
  private VectorData /*P*/ Data;
  
  @Override public String toString() {
    return "" + "Data=" + Data; // NOI18N
  }
}
