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

package org.llvm.cl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;


// Define how to hold a class type object, such as a string.
// Originally this code inherited from std::vector. In transitioning to a new
// API for command line options we should change this. The new implementation
// of this list_storage specialization implements the minimum subset of the
// std::vector API required for all the current clients.
//
// FIXME: Reduce this API to a more narrow subset of std::vector
//
/*template <class int> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1359,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1296,
 FQN="llvm::cl::list_storage<type-parameter-0-0, bool>", NM="_ZN4llvm2cl12list_storageIT_bEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bEE")
//</editor-fold>
public interface/*class*/ list_storageStringBool  {
  public class $Fields {
    public std.vectorString Storage = new std.vectorString();
  }
  public $Fields $list_storage$Fields();
 //public/*private*/ std.vectorString Storage;
/*public:*/
  // JAVA: typedef typename std::vector<int>::iterator iterator
//  public final class iterator extends std.vector.iterator<int>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1365,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1302,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::begin", NM="_ZN4llvm2cl12list_storageIT_bE5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE5beginEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator begin() {
    return $list_storage$Fields().Storage.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1366,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1303,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::end", NM="_ZN4llvm2cl12list_storageIT_bE3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE3endEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator end() {
    return $list_storage$Fields().Storage.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1369,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1306,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::begin", NM="_ZNK4llvm2cl12list_storageIT_bE5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bE5beginEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator begin$Const() /*const*/ {
    return $list_storage$Fields().Storage.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1370,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1307,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::end", NM="_ZNK4llvm2cl12list_storageIT_bE3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bE3endEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator end$Const() /*const*/ {
    return $list_storage$Fields().Storage.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::size">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1373,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1310,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::size", NM="_ZNK4llvm2cl12list_storageIT_bE4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bE4sizeEv")
  //</editor-fold>
  public default/*interface*/  int size() /*const*/ {
    return $list_storage$Fields().Storage.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1375,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1312,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::empty", NM="_ZNK4llvm2cl12list_storageIT_bE5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bE5emptyEv")
  //</editor-fold>
  public default/*interface*/ boolean empty() /*const*/ {
    return $list_storage$Fields().Storage.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::push_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1377,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1314,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::push_back", NM="_ZN4llvm2cl12list_storageIT_bE9push_backERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE9push_backERKS2_")
  //</editor-fold>
  public default/*interface*/ void push_back_T$C$R(std.string value) {
    $list_storage$Fields().Storage.push_back(value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::push_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1378,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1315,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::push_back", NM="_ZN4llvm2cl12list_storageIT_bE9push_backEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE9push_backEOS2_")
  //</editor-fold>
  public default/*interface*/ void push_back_T$RR(std.string value) {
    $list_storage$Fields().Storage.push_back(value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1382,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1319,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator[]", NM="_ZN4llvm2cl12list_storageIT_bEixENSt6vectorIS2_SaIS2_EE9size_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bEixENSt6vectorIS2_SaIS2_EE9size_typeE")
  //</editor-fold>
  public default/*interface*/  std.string $at( int pos) {
    return $list_storage$Fields().Storage.$at(pos);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1383,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1320,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator[]", NM="_ZNK4llvm2cl12list_storageIT_bEixENSt6vectorIS2_SaIS2_EE9size_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bEixENSt6vectorIS2_SaIS2_EE9size_typeE")
  //</editor-fold>
  public default/*interface*/  std.string $at$Const( int pos) /*const*/ {
    return $list_storage$Fields().Storage.$at(pos);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1385,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1322,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::erase", NM="_ZN4llvm2cl12list_storageIT_bE5eraseENSt6vectorIS2_SaIS2_EE14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE5eraseENSt6vectorIS2_SaIS2_EE14const_iteratorE")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator erase(std.vectorString.iterator pos) {
    return $list_storage$Fields().Storage.erase(pos);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1386,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1323,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::erase", NM="_ZN4llvm2cl12list_storageIT_bE5eraseENSt6vectorIS2_SaIS2_EE14const_iteratorES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE5eraseENSt6vectorIS2_SaIS2_EE14const_iteratorES7_")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator erase(std.vectorString.iterator first, std.vectorString.iterator last) {
    return $list_storage$Fields().Storage.erase(first, last);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1395,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1332,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::insert", NM="_ZN4llvm2cl12list_storageIT_bE6insertENSt6vectorIS2_SaIS2_EE14const_iteratorERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE6insertENSt6vectorIS2_SaIS2_EE14const_iteratorERKS2_")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator insert_iterator$int_T$C$R(std.vectorString.iterator pos, final /*const*/ std.string value) {
    return $list_storage$Fields().Storage.insert(pos, value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1398,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1335,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::insert", NM="_ZN4llvm2cl12list_storageIT_bE6insertENSt6vectorIS2_SaIS2_EE14const_iteratorEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE6insertENSt6vectorIS2_SaIS2_EE14const_iteratorEOS2_")
  //</editor-fold>
  public default/*interface*/ std.vectorString.iterator insert_iterator$int_T$RR(std.vectorString.iterator pos, final /*const*/ std.string value) {
    return $list_storage$Fields().Storage.insert(pos, value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::front">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1346,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::front", NM="_ZN4llvm2cl12list_storageIT_bE5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bE5frontEv")
  //</editor-fold>
  public default/*interface*/  std.string front() {
    return $list_storage$Fields().Storage.front();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::front">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1410,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1347,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::front", NM="_ZNK4llvm2cl12list_storageIT_bE5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bE5frontEv")
  //</editor-fold>
  public default/*interface*/  std.string front$Const() /*const*/ {
    return $list_storage$Fields().Storage.front();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> > & ">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1412,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1349,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator vector<type-parameter-0-0, allocator<type-parameter-0-0> > & ", NM="_ZN4llvm2cl12list_storageIT_bEcvRSt6vectorIS2_SaIS2_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bEcvRSt6vectorIS2_SaIS2_EEEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString /*&*/ $vector$int() {
    return $list_storage$Fields().Storage;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator ArrayRef<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1413,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1350,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator ArrayRef<type-parameter-0-0>", NM="_ZN4llvm2cl12list_storageIT_bEcvNS_8ArrayRefIS2_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bEcvNS_8ArrayRefIS2_EEEv")
  //</editor-fold>
  public default/*interface*/ ArrayRef<std.string> $ArrayRef() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator&">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1414,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1351,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator&", NM="_ZN4llvm2cl12list_storageIT_bEadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl12list_storageIT_bEadEv")
  //</editor-fold>
  public default/*interface*/ std.vectorString /*P*/ $addr() {
    return $AddrOf($list_storage$Fields().Storage);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::operator&">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1415,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1352,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::operator&", NM="_ZNK4llvm2cl12list_storageIT_bEadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl12list_storageIT_bEadEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ std.vectorString /*P*/ $addr$Const() /*const*/ {
    return $AddrOf($list_storage$Fields().Storage);
  }

  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::list_storage<type-parameter-0-0, bool>::addValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1417,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1354,
   FQN="llvm::cl::list_storage<type-parameter-0-0, bool>::addValue", NM="Tpl__ZN4llvm2cl12list_storageIT_bE8addValueERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl12list_storageIT_bE8addValueERKT_")
  //</editor-fold>
  public default/*interface*/void addValue(final /*const*/ std.string /*&*/ V) {
    $list_storage$Fields().Storage.push_back(V);
  }

  public default/*interface*/ void list_storage$reset() {
    $list_storage$Fields().Storage.clear();
  }
  
//  @Override public String toString() {
//    return "" + "Storage=" + Storage; // NOI18N
//  }
}
