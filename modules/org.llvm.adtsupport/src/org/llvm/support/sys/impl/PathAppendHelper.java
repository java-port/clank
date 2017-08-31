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

package org.llvm.support.sys.impl;

import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.SmallVector;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class PathAppendHelper {
  private static final ThreadLocal<PathAppendHelper> Helpers = new ThreadLocal<PathAppendHelper>() {

    @Override
    protected PathAppendHelper initialValue() {
      return new PathAppendHelper();
    }    
  };
  
  public static PathAppendHelper $get() {
    PathAppendHelper out = Helpers.get();
    assert !out.inUse && (out.inUse = true) : "already in use";
    return out;
  }

  public static void $release(PathAppendHelper helper) {
    assert Helpers.get() == helper : "release from another thread";
    assert helper.inUse && !(helper.inUse = false) : "release of unused helper";
    helper.release();
  }
  
  private boolean inUse = false;
  private final SmallString/*32*/ a_storage/*J*/ = new SmallString(32);
  private final SmallString/*32*/ b_storage/*J*/ = new SmallString(32);
  private final SmallString/*32*/ c_storage/*J*/ = new SmallString(32);
  private final SmallString/*32*/ d_storage/*J*/ = new SmallString(32);
  private final StringRef a_StringRef/*J*/ = new StringRef(); // should be own instance
  private final StringRef b_StringRef/*J*/ = new StringRef(); // should be own instance
  private final StringRef c_StringRef/*J*/ = new StringRef(); // should be own instance
  private final StringRef d_StringRef/*J*/ = new StringRef(); // should be own instance
  private final static StringRef DEFAULT_COMPONENT_VALUE = new StringRef(); /*do not use StringRef.EMPTY, because it is cloned by SmallVector */
  private final SmallVector<StringRef> components = new SmallVector<StringRef>(4, DEFAULT_COMPONENT_VALUE);

  private PathAppendHelper() {
  }

  public SmallString $a_storage() {
    return a_storage;
  }

  public SmallString $b_storage() {
    return b_storage;
  }

  public SmallString $c_storage() {
    return c_storage;
  }

  public SmallString $d_storage() {
    return d_storage;
  }

  public StringRef $a_StringRef() {
    return a_StringRef;
  }

  public StringRef $b_StringRef() {
    return b_StringRef;
  }

  public StringRef $c_StringRef() {
    return c_StringRef;
  }

  public StringRef $d_StringRef() {
    return d_StringRef;
  }

  public SmallVector<StringRef> $components() {
    return components;
  }
  
  void release() {
    this.a_storage.clear();
    this.b_storage.clear();
    this.c_storage.clear();
    this.d_storage.clear();
    this.a_StringRef.$release();
    this.b_StringRef.$release();
    this.c_StringRef.$release();
    this.c_StringRef.$release();
    this.components.clear();
  }
}
