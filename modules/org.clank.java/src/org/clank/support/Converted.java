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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 */

package org.clank.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker for converted action
 * @author Vladimir Voskresensky
 * @author Petr Kudriavtsev
 * @author Egor Ushakov
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
public @interface Converted {
    
    public enum Kind {
        DUMMY, // dummy implementation
        AUTO, // auto converted
        BODY_DELEGATE, // delegates to the function implementation defined in another class
//        @Deprecated
        MANUAL, // manually converted or fixed auto conversion (use dedicated MANUAL_* instead)
        MANUAL_NON_JAVA, // manually fixed to handle non-java case (i.e. this+1)
        MANUAL_SEMANTIC, // manually fixed JConvert-based semantic error (i.e. added manual clone of intput parameter)
        MANUAL_COMPILATION, // manually fixed JConvert-based compile error (i.e. manual cast variable from long/*uint*/ to int)
        MANUAL_DUPLICATED, // manually duplicated from real declaration (to increase performance for instance)
        MANUAL_ADDED,      // manually added something which is not in c++ code
        AUTO_NO_BODY, // auto converted without bodies
        MANUAL_NO_BODY, // fixed incorrect auto conversion without bodies
        DELETED, // has to be removed from the code
        INSTANTIATION, // created via "Convert instantiations"
        MANUAL_INSTANTIATION, // created via "Convert instantiations" and then fixed manually
        DEPRECATED // has to be removed from the code, but most likely will remain
    }

    public enum Optimization {
      NONE,
      COMPLEX, // manually modified code to optimize memory/speed
      VALUE_TYPE, // manually modified code to reuse instances instead (i.e. of allocating per call)
    }
    
    public enum Notes {
      NONE,
      FIXME,
      FAILED
    }

    /**
     * Kind of the convertation
     */
    Kind kind();

    /**
     * Kind of the optimization
     */
    Optimization optimized() default Optimization.NONE;
    
    /**
     * Kind of update status for the annotation itself
     */
    Notes notes() default Notes.NONE;
    
    /**
     * status of semantic correctness
     * @return 
     */
    boolean done() default false;
    /**
     * Source file where the object resided
     */
    String source() default "";
    
    /**
     * Source file where the object resided in the previous version
     */
    String old_source() default "";

    /**
     * name mangled for this object (as in NM utility output)
     */
    String NM() default "";

    /**
     * FQN name for this object
     */
    String FQN() default "";
    
    /**
     * Line in the source file where the object resided
     */
    int line() default -1;
    
    /**
     * Line in the source file where the object resided in the previous version
     */
    int old_line() default -1;
    
    /**
     * Command to generate the object
     */
    String cmd() default "";

    /**
     * original codebase name used to generate the object
     */    
    String origin() default "";
    
    /**
     * VCS revision used to generate the object
     */
    String revision() default "";
    
}
