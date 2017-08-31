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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;


//===----------------------------------------------------------------------===//
/// UniqueVector - This class produces a sequential ID number (base 1) for each
/// unique entry that is added.  T is the type of entries in the vector. This
/// class should have an implementation of operator== and of operator<.
/// Entries can be fetched using operator[] with the entry ID.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 25,
 FQN="llvm::UniqueVector", NM="_ZN4llvm12UniqueVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm12UniqueVectorE")
//</editor-fold>
public class UniqueVector</*class*/ T>  {
/*public:*/
  /*typedef typename std::vector<T> VectorType*/
//  public final class VectorType extends  std.vector<T>{ };
  /*typedef typename VectorType::iterator iterator*/
//  public final class iterator extends std.vector.iterator<T>{ };
  /*typedef typename VectorType::const_iterator const_iterator*/
//  public final class const_iterator extends std.vector.iterator<T>{ };
/*private:*/
  // Map - Used to handle the correspondence of entry to ID.
  private std.mapTypeUInt Map;
  
  // Vector - ID ordered vector of entries. Entries can be indexed by ID - 1.
  //
  private  std.vector<T> Vector;
/*public:*/
  /// insert - Append entry to the vector if it doesn't already exist.  Returns
  /// the entry's index + 1 to be used as a unique ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 42,
   FQN="llvm::UniqueVector::insert", NM="_ZN4llvm12UniqueVector6insertERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm12UniqueVector6insertERKT_")
  //</editor-fold>
  public /*uint*/int insert(/*const*/ T /*&*/ Entry) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// idFor - return the ID for an existing entry.  Returns 0 if the entry is
  /// not found.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::idFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 59,
   FQN="llvm::UniqueVector::idFor", NM="_ZNK4llvm12UniqueVector5idForERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVector5idForERKT_")
  //</editor-fold>
  public /*uint*/int idFor(/*const*/ T /*&*/ Entry) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// operator[] - Returns a reference to the entry with the specified ID.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 72,
   FQN="llvm::UniqueVector::operator[]", NM="_ZNK4llvm12UniqueVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVectorixEj")
  //</editor-fold>
  public /*const*/ T /*&*/ $at(/*uint*/int ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return an iterator to the start of the vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 78,
   FQN="llvm::UniqueVector::begin", NM="_ZN4llvm12UniqueVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm12UniqueVector5beginEv")
  //</editor-fold>
  public std.vector.iterator<T> begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return an iterator to the start of the vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 81,
   FQN="llvm::UniqueVector::begin", NM="_ZNK4llvm12UniqueVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVector5beginEv")
  //</editor-fold>
  public std.vector.iterator<T> begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return an iterator to the end of the vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 84,
   FQN="llvm::UniqueVector::end", NM="_ZN4llvm12UniqueVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm12UniqueVector3endEv")
  //</editor-fold>
  public std.vector.iterator<T> end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return an iterator to the end of the vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 87,
   FQN="llvm::UniqueVector::end", NM="_ZNK4llvm12UniqueVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVector3endEv")
  //</editor-fold>
  public std.vector.iterator<T> end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// size - Returns the number of entries in the vector.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 91,
   FQN="llvm::UniqueVector::size", NM="_ZNK4llvm12UniqueVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVector4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// empty - Returns true if the vector is empty.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 95,
   FQN="llvm::UniqueVector::empty", NM="_ZNK4llvm12UniqueVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm12UniqueVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// reset - Clears all the entries.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::UniqueVector::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/UniqueVector.h", line = 99,
   FQN="llvm::UniqueVector::reset", NM="_ZN4llvm12UniqueVector5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm12UniqueVector5resetEv")
  //</editor-fold>
  public void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + ", Vector=" + Vector; // NOI18N
  }
}
