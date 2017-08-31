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

package org.clank.java;

import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.java.stdimpl.aliases.*;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;
import org.clank.java.impl.AlteredHashMap;
import org.clank.java.impl.CloneableIterator;
import org.clank.support.Destructors;
import org.clank.support.Native;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$Move;
import static org.clank.support.Native.$tryClone;
import org.clank.support.NativeTrace;

/**
 *
 * @author petrk
 */
public interface std_unordered_map {
  
  public static class unordered_mapTypeType<K, V> extends StdUnorderedMapTypeType<K, V> {
    
    public unordered_mapTypeType(std.hash<K> HashFun, Supplier<V> supplier) {
      super(HashFun, new std.equal_to<K>() {}, supplier);
    }
    
    public unordered_mapTypeType(std.hash<K> HashFun, std.binary_functionBoolean<K> EqualFun, Supplier<V> supplier) {
      super(HashFun, EqualFun, supplier);
    }
    
    public unordered_mapTypeType(unordered_mapTypeType<K, V> other) {
      super(other);
    }
    
    public unordered_mapTypeType(JD$Move $Param, unordered_mapTypeType<K, V> other) {
      super($Param, other);
    }
  }
  
  public static class unordered_mapTypePtr<K, V> extends StdUnorderedMapTypePtr<K, V> {
    
    public unordered_mapTypePtr(std.hash<K> HashFun) {
      super(HashFun, new std.equal_to<K>() {}, ()->null);
    }
    
    public unordered_mapTypePtr(std.hash<K> HashFun, std.binary_functionBoolean<K> EqualFun) {
      super(HashFun, EqualFun, ()->null);
    }
    
    public unordered_mapTypePtr(unordered_mapTypePtr<K, V> other) {
      super(other);
    }
    
    public unordered_mapTypePtr(JD$Move $Param, unordered_mapTypePtr<K, V> other) {
      super($Param, other);
    }
  }
}
