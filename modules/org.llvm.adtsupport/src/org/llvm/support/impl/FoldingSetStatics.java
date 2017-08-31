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
package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type FoldingSetStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZL10GetNextPtrPv;_ZL12GetBucketForjPPvj;_ZL12GetBucketPtrPv;_ZL15AllocateBucketsj; -static-type=FoldingSetStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class FoldingSetStatics {

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static final FoldingSetImpl.Node EMPTY_NODE = new FoldingSetImpl.Node() {
    @Override
    public Object getNextInBucket() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void SetNextInBucket(Object N) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void Profile(FoldingSetNodeID ID) {
      throw new UnsupportedOperationException("Not supported.");
    }
  };

//===----------------------------------------------------------------------===//
/// Helper functions for FoldingSetImpl.

/// GetNextPtr - In order to save space, each bucket is a
/// singly-linked-list. In order to make deletion more efficient, we make
/// the list circular, so we can delete a node without computing its hash.
/// The problem with this is that the start of the hash buckets are not
/// Nodes.  If NextInBucketPtr is a bucket pointer, this method returns null:
/// use GetBucketPtr when this happens.
//<editor-fold defaultstate="collapsed" desc="GetNextPtr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 191,
 old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 190,
 FQN="GetNextPtr", NM="_ZL10GetNextPtrPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZL10GetNextPtrPv")
//</editor-fold>
public static FoldingSetImpl.Node /*P*/ GetNextPtr(Object/*void P*/ NextInBucketPtr) {
  // The low bit is set if this is the pointer back to the bucket.
// >>>>>>>>>>>
//  if (((reinterpret_cast_Object/*intptr_t*/(NextInBucketPtr) & 1) != 0)) {
//    return null;
//  }
// <<<<<<<<<<<
  // JAVA: implemented interface is natural distinguisher whether ptr points to Node or to Bucket.
  if (!(NextInBucketPtr instanceof FoldingSetImpl.Node)) {
    return null;
  }  
// >>>>>>>>>>>
  return ((/*static_cast*/FoldingSetImpl.Node /*P*/ )(NextInBucketPtr));
}


/// testing.
//<editor-fold defaultstate="collapsed" desc="GetBucketPtr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 201,
 old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 200,
 FQN="GetBucketPtr", NM="_ZL12GetBucketPtrPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZL12GetBucketPtrPv")
//</editor-fold>
public static type$ptr<Object>/*void PP*/ GetBucketPtr(Object/*void P*/ NextInBucketPtr) {
  Object/*intptr_t*/ Ptr = reinterpret_cast_Object/*intptr_t*/(NextInBucketPtr);
// >>>>>>>>>>>
//  assert (((Ptr & 1) != 0)) : "Not a bucket pointer";
//  return ((type$ptr<Object>/*void PP*/ )reinterpret_cast(type$ptr.class, Ptr & ~((Object/*intptr_t*/)(1))));
// <<<<<<<<<<<
// JAVA: implemented interface is natural distinguisher whether ptr points to Node or to Bucket.
  assert (!(Ptr instanceof FoldingSetImpl.Node)) : "Not a bucket pointer";
// >>>>>>>>>>>
  return (type$ptr<Object>) Ptr;
}


/// GetBucketFor - Hash the specified node ID and return the hash bucket for
/// the specified ID.
//<editor-fold defaultstate="collapsed" desc="GetBucketFor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 209,
 old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 208,
 FQN="GetBucketFor", NM="_ZL12GetBucketForjPPvj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZL12GetBucketForjPPvj")
//</editor-fold>
public static <T> type$ptr<T>/*void PP*/ GetBucketFor(/*uint*/int Hash, type$ptr<T>/*void PP*/ Buckets, /*uint*/int NumBuckets) {
  // NumBuckets is always a power of 2.
  /*uint*/int BucketNum = Hash & (NumBuckets - 1);
  return Buckets.$add(BucketNum);
}


/// AllocateBuckets - Allocated initialized bucket memory.
//<editor-fold defaultstate="collapsed" desc="AllocateBuckets">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 216,
 old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 215,
 FQN="AllocateBuckets", NM="_ZL15AllocateBucketsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZL15AllocateBucketsj")
//</editor-fold>
public static <T> type$ptr<T>/*void PP*/ AllocateBuckets(/*uint*/int NumBuckets) {
  type$ptr<T>/*void PP*/ Buckets = $tryClone(((/*static_cast*/type$ptr<T>/*void PP*/ )(calloc(NumBuckets + 1, true ? 1 : sizeof(Object.class/*void P*/ )))));
  // Set the very last bucket to be a non-null "pointer".
  ((type$ptr)Buckets).$set(NumBuckets, EMPTY_NODE);
  return Buckets;
}

} // END OF class FoldingSetStatics
